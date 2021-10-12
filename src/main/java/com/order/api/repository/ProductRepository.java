package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.repository.entities.Products;

public interface ProductRepository extends JpaRepository<Products, String>{

}
