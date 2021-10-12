package com.order.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.api.controller.OrderController;

@SpringBootTest
class ApiApplicationTests {
	
	@Autowired
	private OrderController orderController;

	@Test
	void contextLoads() {
		assertThat(orderController).isNotNull();
	}

}
