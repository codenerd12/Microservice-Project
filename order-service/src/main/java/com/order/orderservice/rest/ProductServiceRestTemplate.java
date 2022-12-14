package com.order.orderservice.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.order.orderservice.request.OrderRequest;
import com.order.orderservice.response.Product;

@Component("productServiceRestTemplate")
public class ProductServiceRestTemplate {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public List<Product> getProductsFromProductService(OrderRequest orderRequest) {
		
		List<Product> products = orderRequest.getProductIds().stream()
				.map(this::getProductInfoFromProductService)
				.collect(Collectors.toList());
		
		return products;
		
	}
	
	private Product getProductInfoFromProductService(Long productId) {
		
		return webClientBuilder.build().get().uri("http://product-service/api/product/"+productId)
				.retrieve().bodyToMono(Product.class)
				.block();  //synchronus request using block method
	}

}
