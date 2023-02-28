package com.example.fe.service;

import com.example.fe.model.Order;
import com.example.fe.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Boolean checkQuantity(Long productId, Integer quantity);

    List<Order> getOrders();

    String saveOrder(Order order);
    Product getProductById(Long id);
}
