package com.order.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.orderservice.request.OrderRequest;
import com.order.orderservice.response.OrderResponse;
import com.order.orderservice.response.Product;
import com.order.orderservice.rest.ProductServiceRestTemplate;
import com.order.orderservice.rest.feign.ProductServiceProxy;

@Service("orderService")
public class OrderService {

	@Autowired
	private ProductServiceRestTemplate productServiceRestTemplate;
	
	@Autowired
	ProductServiceProxy productServiceProxy;
	
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderRequest.getOrderId());
		List<Product> products = productServiceRestTemplate.getProductsFromProductService(orderRequest);
		orderResponse.setProduct(products);
		return orderResponse;
		
	}

	public OrderResponse placeOrderUsingFeignClient(OrderRequest orderRequest) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderRequest.getOrderId());
		List<Product> products = orderRequest.getProductIds().stream()
									.map(this::getProductsFromProductServiceUsingFeign)
									.collect(Collectors.toList());
		orderResponse.setProduct(products);
									
		return orderResponse;
	}

	//Getting products using feign client in microservice
	private Product getProductsFromProductServiceUsingFeign(Long productId) {
		return productServiceProxy.getProductsFromProductService(productId);
	}

	
	
	
	
	

}
