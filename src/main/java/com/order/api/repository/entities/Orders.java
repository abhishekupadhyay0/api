package com.order.api.repository.entities;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
		@Id
		@Column(name = "order_id")
		private int order_id;

		@Column(name = "order_date")
		private Date order_date;

		public Orders() {
			super();
		}

		public Orders(int order_id, Date order_date) {
			super();
			this.order_id = order_id;
			this.order_date = order_date;
		}

		public int getOrder_id() {
			return order_id;
		}

		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}

		public Date getOrder_date() {
			return order_date;
		}

		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}

		
}
