package com.example.fe.controller;

import com.example.fe.model.Order;
import com.example.fe.model.Product;
import com.example.fe.model.Status;
import com.example.fe.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("home")
public class ProductController {
    private final IProductService productService;

    @GetMapping
    public String getProduct(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/order/{productId}")
    public String buyProduct(@PathVariable Long productId, Model model) {
        if (productService.checkQuantity(productId, 1)) {
            Product product = productService.getProductById(productId);
            Order order = new Order(null, "Nguyen Tuan Kiet", "HCM", product.getPrice(), new Product(productId, null, null, null, null), Status.PENDING);
            System.out.println(order);
            String result = productService.saveOrder(order);
            List<Order> orders = productService.getOrders();
            model.addAttribute("orders", orders);
            return "orders";
        } else {
            Product product = productService.getProductById(productId);
            Order order = new Order(null, "Nguyen Tuan Kiet", "HCM", product.getPrice(), new Product(productId, null, null, null, null), Status.FAILED);
            System.out.println(order);
            String result = productService.saveOrder(order);
            List<Order> orders = productService.getOrders();
            model.addAttribute("orders", orders);
            return "orders";
        }
    }
}
