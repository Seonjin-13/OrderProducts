package com.sparta.orderproduct.order.dto;

import com.sparta.orderproduct.order.entity.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private final Long orderId;
    private final Long productId;
    private final String productName;
    private final Integer productQuantity;
    private final Integer productPrice;
    private final Integer totalPrice;
    private final String status;
    private final LocalDateTime createdAt;

    public OrderResponseDto(Order order) {
        this.orderId = order.getOrderId();
        this.productId = order.getProduct().getProductId();
        this.productName = order.getProduct().getProductName();
        this.productQuantity = order.getProductQuantity();
        this.productPrice = order.getProductPrice();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
    }
}
