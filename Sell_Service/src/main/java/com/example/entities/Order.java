package com.example.entities;

import com.example.utils.EOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_SEQ")
    @SequenceGenerator(name = "Order_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private Long total;
    private EOrderStatus status;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


}