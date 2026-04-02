package com.sparta.orderproduct.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductRequestDto {
    @NotBlank(message = "상품명을 입력해주세요.")
    private String productName;

    @NotNull(message = "가격을 입력해주세요.")
    @Min(value = 0, message = "가격은 0원 이상이어야 합니다.")
    private Integer productPrice;

    @NotNull(message = "재고를 입력해주세요.")
    @Min(value = 0, message = "재고는 0개 이상이어야 합니다.")
    private Integer productStock;
}
