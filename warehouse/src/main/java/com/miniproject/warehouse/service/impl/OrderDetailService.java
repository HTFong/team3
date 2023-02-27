package com.miniproject.warehouse.service.impl;

import com.miniproject.warehouse.entity.OrderDetail;
import com.miniproject.warehouse.entity.OrderStatus;
import com.miniproject.warehouse.repository.OrderDetailRepository;
import com.miniproject.warehouse.service.IOrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;

    public OrderDetailService(OrderDetailRepository orderDetailRepository, ProductService productService) {
        this.orderDetailRepository = orderDetailRepository;
        this.productService = productService;
    }

    @Override
    public OrderDetail updateStatus(Long id, OrderStatus status) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);
        orderDetail.setStatus(status);
        if (productService.checkQuantity(orderDetail.getProductId(), orderDetail.getQuantity())) {
            productService.updateQuantity(orderDetail.getProductId(), orderDetail.getQuantity());
            OrderDetail orderDetailNew = orderDetailRepository.save(orderDetail);
            return orderDetailNew;
        }
        return null;
    }

    @Override
    public OrderDetail addNew(OrderDetail orderDetail) {
        OrderDetail orderDetailNew;
        try {
            orderDetailNew = orderDetailRepository.save(orderDetail);
            return orderDetailNew;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }
}
