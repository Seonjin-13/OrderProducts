package com.sparta.orderproduct.order.controller;

import com.sparta.orderproduct.order.dto.OrderRequestDto;
import com.sparta.orderproduct.order.dto.OrderResponseDto;

import com.sparta.orderproduct.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/orders/{orderId}")
    public OrderResponseDto getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders() {
        return orderService.getOrders();
    }
}