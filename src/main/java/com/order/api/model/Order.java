package com.order.api.model;

import java.util.List;

public class Order {
	private int orderId;
	private List<OrderItems> items;
	
	public Order() {
		super();
	}

	public Order(int orderId, List<OrderItems> items) {
		super();
		this.orderId = orderId;
		this.items = items;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<OrderItems> getItems() {
		return items;
	}
	public void setItems(List<OrderItems> items) {
		this.items = items;
	}

}
