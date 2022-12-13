package com.product.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	//@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="product_name")
	private String productName;
	
	public Product() {}
	
	public Product(Long id, String productName) {
		super();
		this.id = id;
		this.productName = productName;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
