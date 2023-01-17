package com.example.sprboot.config;

import com.example.sprboot.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductConfig {

    @Bean
    public Product product1() {
        return new Product(1, "name1", BigDecimal.valueOf(10));
    }

    @Bean
    public Product product2() {
        return new Product(2, "name2", BigDecimal.valueOf(20));
    }

    @Bean
    public Product product3() {
        return new Product(3, "name3", BigDecimal.valueOf(30));
    }

}
