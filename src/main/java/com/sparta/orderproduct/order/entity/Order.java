package com.sparta.orderproduct.order.entity;

import com.sparta.orderproduct.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Order(Product product, Integer productQuantity, String status) {
        this.product = product;
        this.productQuantity = productQuantity;
        this.productPrice = product.getProductPrice();
        this.totalPrice = this.productPrice * this.productQuantity;
        this.status = "CREATED";
    }
}
