package com.sparta.orderproduct.order.dto;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long productId;
    private Integer productQuantity;
}
