package com.sparta.orderproduct.product.service;

import com.sparta.orderproduct.product.dto.ProductRequestDto;
import com.sparta.orderproduct.product.dto.ProductResponseDto;
import com.sparta.orderproduct.product.entity.Product;
import com.sparta.orderproduct.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);

        Product saveProduct = productRepository.save(product);

        return new ProductResponseDto(saveProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponseDto getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        product.update(productRequestDto);

        Product updateProduct = productRepository.save(product);

        return new ProductResponseDto(updateProduct);
    }

    @Transactional
    public String deleteProduct(Long productId) {
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
