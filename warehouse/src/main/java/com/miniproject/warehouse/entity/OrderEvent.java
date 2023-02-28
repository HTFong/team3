package com.miniproject.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private Long id;

    private String specificAddress;

    private Long productId;

    private Integer quantity;

    private OrderStatus status;
}
