package com.sparta.orderproduct.product.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String product_name;
    private Integer product_price;
    private Integer product_stock;
}
