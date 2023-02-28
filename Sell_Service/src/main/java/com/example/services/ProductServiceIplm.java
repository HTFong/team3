package com.example.services;

import com.example.dto.ProductDto;
import com.example.repositories.ProductRepository;
import com.example.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIplm implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductDto> getAll() {
        return Mapper.mapAll(productRepository.findAll(),ProductDto.class);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return Mapper.map(productRepository.findById(id).get(), ProductDto.class);
    }
}
