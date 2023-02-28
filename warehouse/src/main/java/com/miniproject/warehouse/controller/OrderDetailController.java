package com.miniproject.warehouse.controller;

import com.miniproject.warehouse.entity.OrderDetail;
import com.miniproject.warehouse.entity.OrderEvent;
import com.miniproject.warehouse.entity.OrderStatus;
import com.miniproject.warehouse.service.IOrderDetailService;
import lombok.AllArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/warehouse/order")
public class OrderDetailController {

    @KafkaListener(topics = "topicorderevent", id = "ordergroup")
    public void listen(OrderEvent orderDto) {
        //process db
        // convert dto to entity + save
        OrderDetail entity = new OrderDetail();
     //   entity.setId(orderDto.getId());
        entity.setQuantity(orderDto.getQuantity());
        entity.setProductId(orderDto.getProductId());
        entity.setStatus(orderDto.getStatus());
        entity.setSpecificAddress(orderDto.getSpecificAddress());
        System.out.println("da nhan don hang");
        orderDetailService.addNew(entity);
        //
    }
    private IOrderDetailService orderDetailService;

    @PutMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestParam Long id, @RequestParam OrderStatus status) {
        try {
            OrderDetail orderDetail = orderDetailService.updateStatus(id, status);
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail orderDetailNew = orderDetailService.addNew(orderDetail);
            return new ResponseEntity<>(orderDetailNew, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getOrders() {
        try {
            return ResponseEntity.ok().body(orderDetailService.getAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
