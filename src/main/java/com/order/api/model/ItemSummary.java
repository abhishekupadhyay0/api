package com.order.api.model;

public class ItemSummary {
	private OrderItems orderItems;
	private double price;
	private String offerApplied;
	
	public ItemSummary(OrderItems orderItems, double price, String offerApplied) {
		super();
		this.orderItems = orderItems;
		this.price = price;
		this.offerApplied = offerApplied;
	}
	
	public OrderItems getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOfferApplied() {
		return offerApplied;
	}
	public void setOfferApplied(String offerApplied) {
		this.offerApplied = offerApplied;
	}
	
}
