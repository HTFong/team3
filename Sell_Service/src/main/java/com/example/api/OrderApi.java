package com.example.api;

import com.example.dto.OrderDto;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> orderDtos = orderService.getAll();
        if (orderDtos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDto orderDto) {
        try {
            //send message broker to warehouse
            orderService.save(orderDto);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable Long id) {
        try {
            orderService.changeStatus(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
        }
    }
}
