package com.sparta.orderproduct.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderRequestDto {
    @NotNull(message = "상품 ID를 입력해주세요.")
    private Long productId;

    @NotNull(message = "주문 수량을 입력해주세요.")
    @Min(value = 1, message = "주문 수량은 최소 1개 이상이어야 합니다.")
    private Integer productQuantity;
}
