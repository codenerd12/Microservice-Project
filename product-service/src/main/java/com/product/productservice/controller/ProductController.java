package com.product.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.productservice.model.Product;
import com.product.productservice.request.ProductModel;
import com.product.productservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value = "/products")
	public List<Product> findAll() {
		return productService.findAllProducts();
	}
	
	@GetMapping(value = "/{id}")
	public Product findProduct(@PathVariable Long id) {
		return productService.findProduct(id);
	}
	
	@PostMapping(value = "/create")
	public void createProduct(@RequestBody ProductModel productModel) {
		productService.saveProduct(productModel);
	}
	
	
}
