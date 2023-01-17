package com.example.sprboot.repository;

import com.example.sprboot.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
@Setter
public class ProductRepository {

    private List<Product> productList;

    public void printAllProducts() {
        System.out.println("Available products");
        productList.stream()
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

    public void printProductById(int id) {
        System.out.println("Selected product");
        productList.stream()
                .filter(p -> (p.getId() == id))
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

}
