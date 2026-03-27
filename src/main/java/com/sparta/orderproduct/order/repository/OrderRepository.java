package com.sparta.orderproduct.order.repository;

import com.sparta.orderproduct.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
