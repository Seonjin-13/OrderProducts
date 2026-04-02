package com.sparta.orderproduct.product.entity;

import com.sparta.orderproduct.exception.OutOfStockException;
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
    private Long productId;

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

    @UpdateTimestamp
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    public Product(ProductRequestDto requestDto) {
        this.productName = requestDto.getProductName();
        this.productPrice = requestDto.getProductPrice();
        this.productStock = requestDto.getProductStock();
    }

    public void update(ProductRequestDto requestDto) {
        this.productName = requestDto.getProductName();
        this.productPrice = requestDto.getProductPrice();
        this.productStock = requestDto.getProductStock();
    }

    public void decreaseStock(int quantity) {
        if (this.productStock < quantity) {
            throw new OutOfStockException("해당 상품의 수량이 부족합니다.");
        }
        this.productStock -= quantity;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}
