package com.order.api.service;

import com.order.api.model.Order;
import com.order.api.model.OrderSummary;

public interface OrderService {
	
	public OrderSummary addItemsInOrder(Order order);
	
	public OrderSummary getOrderSumary(int orderId);

}
