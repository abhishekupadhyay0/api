package com.order.api.model;

import java.util.List;

public class OrderSummary {
	private List<ItemSummary> itemSummary;
	private double totalPrice;
	
	public List<ItemSummary> getItemSummary() {
		return itemSummary;
	}

	public void setItemSummary(List<ItemSummary> itemSummary) {
		this.itemSummary = itemSummary;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderSummary(List<ItemSummary> itemSummary, double totalPrice) {
		super();
		this.itemSummary = itemSummary;
		this.totalPrice = totalPrice;
	}
}
