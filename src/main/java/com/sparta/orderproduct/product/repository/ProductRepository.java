package com.sparta.orderproduct.product.repository;

import com.sparta.orderproduct.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
