package com.sparta.orderproduct.product.dto;

import com.sparta.orderproduct.product.entity.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDto(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productStock = product.getProductStock();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
