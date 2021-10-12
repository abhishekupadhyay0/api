package com.order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.api.model.Order;
import com.order.api.model.OrderSummary;
import com.order.api.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path="/order", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public OrderSummary receiveOrder(@RequestBody Order order){
		
		OrderSummary orderSumary = orderService.addItemsInOrder(order);
		return orderSumary;
	}
	
	@GetMapping(path="/ordersummary/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public OrderSummary receiveOrder(@PathVariable(name="orderId") Integer orderId) {
		System.out.println("orderId " + orderId);
		OrderSummary orderSumary = orderService.getOrderSumary(orderId);
		return orderSumary;
	}

}
