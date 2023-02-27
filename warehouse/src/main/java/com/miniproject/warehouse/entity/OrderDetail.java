package com.miniproject.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    private Long id;

    @Column(columnDefinition = "nvarchar(500)")
    private String specificAddress;

    private Long productId;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nvarchar(50)")
    private OrderStatus status;
}
