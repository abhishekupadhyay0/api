package com.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.api.repository.entities.Items;

public interface ItemRepository extends JpaRepository<Items, Integer>{
	@Query(value= "SELECT * FROM ITEMS WHERE ORDER_ID = ?1", nativeQuery=true)
	List<Items> findByOrderId(int orderId);

}
