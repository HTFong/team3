package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("Sell_Service", r -> r.path("/api/v1/**")
//                        .uri("http://localhost:8081"))
//
//                .route("WareHouse_Service", r -> r.path("/api/warehouse/**")
//                        .uri("http://localhost:8080"))
//                .build();
//    }

}
