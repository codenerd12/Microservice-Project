package com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.request.OrderRequest;
import com.order.orderservice.response.OrderResponse;
import com.order.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create")
	public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
		
		return orderService.placeOrder(orderRequest);
		
	}
	
	@PostMapping("/feign-client/create")
	public OrderResponse placeOrderUsingFeignClient(@RequestBody OrderRequest orderRequest) {
		return orderService.placeOrderUsingFeignClient(orderRequest);
	}
	

}
