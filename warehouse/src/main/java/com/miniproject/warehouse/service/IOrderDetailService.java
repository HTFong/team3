package com.miniproject.warehouse.service;

import com.miniproject.warehouse.entity.OrderDetail;
import com.miniproject.warehouse.entity.OrderStatus;

import java.util.List;

public interface IOrderDetailService {
    OrderDetail updateStatus(Long id, OrderStatus status);

    OrderDetail addNew(OrderDetail orderDetail);

    List<OrderDetail> getAll();
}
