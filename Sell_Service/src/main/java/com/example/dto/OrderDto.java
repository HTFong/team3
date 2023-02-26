package com.example.dto;

import com.example.utils.EOrderStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDto implements Serializable {
    private  Long id;
    private  String name;
    private  String address;
    private  Long total;
    private  ProductDto product;
    private EOrderStatus status;
}
