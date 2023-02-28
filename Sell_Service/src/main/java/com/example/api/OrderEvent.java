package com.example.api;

import com.example.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
