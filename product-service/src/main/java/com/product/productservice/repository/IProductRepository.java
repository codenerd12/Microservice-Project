package com.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.productservice.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}
