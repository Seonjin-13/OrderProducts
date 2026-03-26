package com.sparta.orderproduct.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Product(String productName, Integer productPrice, Integer productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public void update(String productName, Integer productPrice, Integer productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
