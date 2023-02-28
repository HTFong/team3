package com.example;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SellServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellServiceApplication.class, args);
    }
    @Bean
    NewTopic notification() {
        return new NewTopic("topicorderevent", 3, (short) 1);
    }
}
