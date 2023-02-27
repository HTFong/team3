package com.miniproject.warehouse.service;

import com.miniproject.warehouse.entity.Product;

public interface IProductService {
    Product updateQuantity(Long id, int quantity);

    Boolean checkQuantity(Long id, int quantity);
}
