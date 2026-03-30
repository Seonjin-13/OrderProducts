package com.sparta.orderproduct.order.controller;

import com.sparta.orderproduct.order.dto.OrderRequestDto;
import com.sparta.orderproduct.order.dto.OrderResponseDto;
import com.sparta.orderproduct.order.entity.Order;
import com.sparta.orderproduct.order.repository.OrderRepository;
import com.sparta.orderproduct.product.dto.ProductResponseDto;
import com.sparta.orderproduct.product.entity.Product;
import com.sparta.orderproduct.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @PostMapping("/orders")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Product product = productRepository.findById(orderRequestDto.getProduct_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));

        product.decreaseStock(orderRequestDto.getProduct_quantity());

        Order order = new Order(product, orderRequestDto.getProduct_quantity(), "CREATED");
        Order saveOrder = orderRepository.save(order);

        return new OrderResponseDto(saveOrder);
    }

    @GetMapping("/orders/{orderId}")
    public OrderResponseDto getOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));

        return new OrderResponseDto(order);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders() {
        return orderRepository.findAll().stream()
                .map(OrderResponseDto::new)
                .toList();
    }
}