package com.sparta.orderproduct.product.controller;

import com.sparta.orderproduct.product.dto.ProductRequestDto;
import com.sparta.orderproduct.product.dto.ProductResponseDto;
import com.sparta.orderproduct.product.entity.Product;
import com.sparta.orderproduct.product.repository.ProductRepository;
import com.sparta.orderproduct.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public ProductResponseDto getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductResponseDto updateProduct(@PathVariable Long productId,
            @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(productId, productRequestDto);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }
}
