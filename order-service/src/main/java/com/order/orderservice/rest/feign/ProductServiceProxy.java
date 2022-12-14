package com.order.orderservice.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.orderservice.response.Product;

@FeignClient(name="product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/api/product/{productId}")
	public Product getProductsFromProductService(@PathVariable Long productId);
		
		
		

}
