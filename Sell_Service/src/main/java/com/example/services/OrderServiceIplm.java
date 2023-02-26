package com.example.services;

import com.example.dto.OrderDto;
import com.example.entities.Order;
import com.example.repositories.OrderRepository;
import com.example.repositories.ProductRepository;
import com.example.utils.EOrderStatus;
import com.example.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIplm implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void save(OrderDto orderDto) {
        Order order=Mapper.map(orderDto, Order.class);
        order.setStatus(EOrderStatus.PENDING);
        order.setProduct(productRepository.findById(orderDto.getProduct().getId()).get());
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAll() {
        return Mapper.mapAll(orderRepository.findAll(), OrderDto.class);
    }

    @Override
    public void changeStatus(Long id) {
        Order order=orderRepository.findById(id).get();
        order.setStatus(EOrderStatus.CONFIRMED);
        orderRepository.save(order);
    }
}
