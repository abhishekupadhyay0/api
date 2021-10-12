package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Order;
import com.order.api.repository.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	public int save(Order order);

}
