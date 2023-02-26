package com.example.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private  Long id;
    private  String name;
    private  String description;
    private  Long price;
    private  String imageUrl;
}
