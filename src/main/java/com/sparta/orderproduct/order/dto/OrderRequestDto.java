package com.sparta.orderproduct.order.dto;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long product_id;
    private Integer product_quantity;
}
