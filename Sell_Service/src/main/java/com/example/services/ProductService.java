package com.example.services;

import com.example.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();

    ProductDto getProduct(Long id);
}
