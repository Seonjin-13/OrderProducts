package com.sparta.orderproduct.product.entity;

import com.sparta.orderproduct.product.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String product_name;

    @Column(name = "product_price", nullable = false)
    private Integer product_price;

    @Column(name = "product_stock", nullable = false)
    private Integer product_stock;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Product(ProductRequestDto requestDto) {
        this.product_name = requestDto.getProduct_name();
        this.product_price = requestDto.getProduct_price();
        this.product_stock = requestDto.getProduct_stock();
    }

    public void update(ProductRequestDto requestDto) {
        this.product_name = requestDto.getProduct_name();
        this.product_price = requestDto.getProduct_price();
        this.product_stock = requestDto.getProduct_stock();
    }
}
