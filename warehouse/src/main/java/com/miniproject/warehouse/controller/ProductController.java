package com.miniproject.warehouse.controller;

import com.miniproject.warehouse.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/warehouse/product")
public class ProductController {
    private IProductService productService;

    @GetMapping("/check-quantity")
    public ResponseEntity<Boolean> getProductsNoImport(@RequestParam Long id, @RequestParam Integer quantity) {
        return ResponseEntity.ok().body(productService.checkQuantity(id, quantity));
    }
}
