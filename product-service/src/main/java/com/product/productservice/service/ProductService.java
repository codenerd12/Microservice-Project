package com.product.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productservice.model.Product;
import com.product.productservice.repository.IProductRepository;
import com.product.productservice.request.ProductModel;

@Service("productService")
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public void saveProduct(ProductModel productModel) {
		Product product = new Product();
		product.setProductName(productModel.getProductName());
		productRepository.save(product);
	}

	public Product findProduct(Long productId) {
		return productRepository.getProductById(productId);
	}

}
