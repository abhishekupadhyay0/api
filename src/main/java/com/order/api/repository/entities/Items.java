package com.order.api.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
	
	@Id
	@Column(name = "item_id")
	private int item_id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "item_name")
	private String item_name;
	
	@Column(name = "item_desc")
	private String item_desc;
	
	@Column(name = "price")
	private double price;

	public Items() {
		super();
	}

	public Items(int item_id, Orders order, int quantity, String item_name, String item_desc, double price) {
		super();
		this.item_id = item_id;
		this.order = order;
		this.quantity = quantity;
		this.item_name = item_name;
		this.item_desc = item_desc;
		this.price = price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
