package com.order.api.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@Column(name = "item_name")
	private String item_name;
	
	@Column(name = "item_price")
	private int item_price;
	
	@Column(name = "item_offer")
	private String item_offer;
	

	public Products() {
		super();
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public int getItem_price() {
		return item_price;
	}


	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}


	public String getItem_offer() {
		return item_offer;
	}


	public void setItem_offer(String item_offer) {
		this.item_offer = item_offer;
	}

		

}
