package com.product.productservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.product.productservice.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Product getProductById(Long productId) {
		 Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id");
	     query.setParameter("id", productId);

	     return (Product) query.getSingleResult();
	}

}
