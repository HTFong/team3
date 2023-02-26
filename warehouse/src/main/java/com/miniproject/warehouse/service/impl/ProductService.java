package com.miniproject.warehouse.service.impl;

import com.miniproject.warehouse.entity.Product;
import com.miniproject.warehouse.repository.ProductRepository;
import com.miniproject.warehouse.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product updateQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        product.setQuantity(product.getQuantity() - quantity);
        Product productnew = productRepository.save(product);
        return productnew;
    }

    @Override
    public Boolean checkQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if(product.getQuantity()>=quantity){
            return true;
        }else{
            return false;
        }
    }
}
