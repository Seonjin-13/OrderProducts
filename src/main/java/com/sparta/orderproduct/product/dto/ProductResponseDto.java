package com.sparta.orderproduct.product.dto;

import com.sparta.orderproduct.product.entity.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponseDto {
    private Long product_id;
    private String product_name;
    private Integer product_price;
    private Integer product_stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDto(Product product) {
        this.product_id = product.getProduct_id();
        this.product_name = product.getProduct_name();
        this.product_price = product.getProduct_price();
        this.product_stock = product.getProduct_stock();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
