package com.sparta.orderproduct.order.service;

import com.sparta.orderproduct.order.dto.OrderRequestDto;
import com.sparta.orderproduct.order.dto.OrderResponseDto;
import com.sparta.orderproduct.order.entity.Order;
import com.sparta.orderproduct.order.repository.OrderRepository;
import com.sparta.orderproduct.product.entity.Product;
import com.sparta.orderproduct.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Product product = productRepository.findByIdWithLock(orderRequestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        if (product.getDeletedAt() != null) {
            throw new IllegalArgumentException("존재하지 않는 상품입니다.");
        }

        product.decreaseStock(orderRequestDto.getProductQuantity());

        Order order = new Order(product, orderRequestDto.getProductQuantity(), "CREATED");
        Order saveOrder = orderRepository.save(order);

        return new OrderResponseDto(saveOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));

        return new OrderResponseDto(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> getOrders() {
        return orderRepository.findAll().stream()
                .map(OrderResponseDto::new)
                .toList();
    }
}
