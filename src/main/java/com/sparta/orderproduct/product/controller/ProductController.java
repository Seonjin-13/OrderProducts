package com.sparta.orderproduct.product.controller;

import com.sparta.orderproduct.product.dto.ProductRequestDto;
import com.sparta.orderproduct.product.dto.ProductResponseDto;
import com.sparta.orderproduct.product.entity.Product;
import com.sparta.orderproduct.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);

        Product saveProduct = productRepository.save(product);

         return new ProductResponseDto(saveProduct);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .toList();
    }

    @GetMapping("/products/{productId}")
    public ProductResponseDto getProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        return new ProductResponseDto(product);
    }

    @PutMapping("/products/{productId}")
    public ProductResponseDto updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        product.update(productRequestDto);

        Product updateProduct = productRepository.save(product);

        return new ProductResponseDto(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        if (product.getDeletedAt() != null) {
            throw new IllegalStateException("이미 삭제된 상품입니다.");
        }

        product.delete();
        productRepository.save(product);

        return "상품이 삭제되었습니다.";
    }
}
