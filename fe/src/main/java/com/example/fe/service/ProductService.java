package com.example.fe.service;

import com.example.fe.model.Order;
import com.example.fe.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private RestTemplate restTemplate;

    @Override
    public List<Product> getProducts() {
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange("http://localhost:8082/api/v1/product", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public Boolean checkQuantity(Long productId, Integer quantity) {
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8082/api/warehouse/product/check-quantity?id=" + productId + "&quantity=" + quantity, HttpMethod.GET, null,
                new ParameterizedTypeReference<Boolean>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public List<Order> getOrders() {
        ResponseEntity<List<Order>> responseEntity = restTemplate.exchange("http://localhost:8082/api/v1/order", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Order>>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public String saveOrder(Order order) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/v1/order", order, String.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            return null;
        }
    }
}
