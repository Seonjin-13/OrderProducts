package com.sparta.orderproduct.product.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String productName;
    private Integer productPrice;
    private Integer productStock;
}
