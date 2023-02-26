package com.example.services;

import com.example.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void save(OrderDto orderDto);
    List<OrderDto> getAll();
    void changeStatus(Long id);
}
