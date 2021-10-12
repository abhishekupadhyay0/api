package com.order.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;

import com.order.api.controller.OrderController;
import com.order.api.model.ItemSummary;
import com.order.api.model.Order;
import com.order.api.model.OrderItems;
import com.order.api.model.OrderSummary;
import com.order.api.service.OrderService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private OrderController orderController;
	
	@Mock
	private OrderService service;
	

	@Test
	public void testGetOrderSummary() throws Exception {
		
		Order testOrder = new Order();
		testOrder.setOrderId(1);
		List<OrderItems> itemsList = new ArrayList<>();
		OrderItems items = new OrderItems(1, "APPLE", "FRUIT", 5);
		itemsList.add(items);
		testOrder.setItems(itemsList);

		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ordersummary/1",
				String.class)).isNotEmpty();
	}
	
	@Test
	public void addItemsToOrder() {
		Order testOrder = new Order();
		testOrder.setOrderId(1);
		List<OrderItems> itemsList = new ArrayList<>();
		OrderItems items = new OrderItems(1, "APPLE", "FRUIT", 5);
		itemsList.add(items);
		testOrder.setItems(itemsList);
		
		
		ItemSummary item = new ItemSummary(items, 5, "2:3");
		OrderSummary summary = new OrderSummary(null, 10);
		Mockito.when(service.addItemsInOrder(testOrder)).thenReturn(summary);
		
		OrderSummary orderSummary = orderController.receiveOrder(testOrder);
		Assert.notNull(orderSummary);
		
	}
	

}
