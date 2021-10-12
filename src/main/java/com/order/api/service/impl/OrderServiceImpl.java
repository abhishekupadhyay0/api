package com.order.api.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.api.model.ItemSummary;
import com.order.api.model.Order;
import com.order.api.model.OrderItems;
import com.order.api.model.OrderSummary;
import com.order.api.repository.ItemRepository;
import com.order.api.repository.OrderRepository;
import com.order.api.repository.ProductRepository;
import com.order.api.repository.entities.Items;
import com.order.api.repository.entities.Orders;
import com.order.api.repository.entities.Products;
import com.order.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional
	public OrderSummary addItemsInOrder(Order order) {
		double orderPrice = 0;
		List<ItemSummary> summary = new ArrayList<ItemSummary>();
		boolean orderExists = orderRepository.existsById(order.getOrderId());
		Orders existingOrNewOrder;
		if(!orderExists) {
			existingOrNewOrder = new Orders(order.getOrderId(), new Date());
			orderRepository.save(existingOrNewOrder);
		}else {
			existingOrNewOrder = orderRepository.findById(order.getOrderId()).get();
		}
		
		for(OrderItems item: order.getItems()) {
			double itemTotalPrice = calculatePriceOfItems(item.getItemName(), item.getQuantity());
			itemRepository.save(new Items(item.getItemId(), existingOrNewOrder, item.getQuantity(),  item.getItemName(), item.getItemCategory(), itemTotalPrice));
			summary.add(new ItemSummary(item, itemTotalPrice, getOffer(item.getItemName())));
			orderPrice += itemTotalPrice; 
		}
			
		OrderSummary orderSummary = new OrderSummary(summary, orderPrice);
		return orderSummary;
	}
	
	private double calculatePriceOfItems(String itemName, int quantity) {
		System.out.println(productRepository.findById(itemName).get());
		Products product = productRepository.findById(itemName).get();
		int price = product.getItem_price();
		String offer = product.getItem_offer();
		if(null != offer) {
			int buyItems = Character.getNumericValue(product.getItem_offer().charAt(0));
			int getItems = Character.getNumericValue(product.getItem_offer().charAt(2));
			
			return (price * Math.ceil(quantity / getItems * buyItems))/100;
		} else {
			return (price * quantity)/100;
		}
	}
	
	private String getOffer(String itemName) {
		Products product = productRepository.findById(itemName).get();
		return product.getItem_offer();
	}

	@Override
	public OrderSummary getOrderSumary(int orderId) {
		List<Items> itemsInOrder= itemRepository.findByOrderId(orderId);
		double orderTotel = 0;
		List<ItemSummary> summary = new ArrayList<ItemSummary>();
		for(Items item: itemsInOrder) {
			OrderItems orderItems = new OrderItems(item.getItem_id(), item.getItem_name(), item.getItem_desc(), item.getQuantity());
			summary.add(new ItemSummary(orderItems, item.getPrice(), getOffer(item.getItem_name())));
			orderTotel += item.getPrice();
		}
		
		OrderSummary orderSummary = new OrderSummary(summary, orderTotel);
		return orderSummary;
	}

}
