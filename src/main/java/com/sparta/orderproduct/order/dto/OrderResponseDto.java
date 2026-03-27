package com.sparta.orderproduct.order.dto;

import com.sparta.orderproduct.order.entity.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private final Long order_id;
    private final Long product_id;
    private final String product_name;
    private final Integer product_quantity;
    private final String status;
    private final LocalDateTime created_at;

    public OrderResponseDto(Order order) {
        this.order_id = order.getOrder_id();
        this.product_id = order.getProduct().getProduct_id();
        this.product_name = order.getProduct().getProduct_name();
        this.product_quantity = order.getProduct_quantity();
        this.status = order.getStatus();
        this.created_at = order.getCreated_at();
    }
}
