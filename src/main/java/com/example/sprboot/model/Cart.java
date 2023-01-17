package com.example.sprboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope("prototype")
@Getter
@Setter
public class Cart {

    private List<Product> cartList;

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
        cartList.clear();
    }

    public void printCartList() {
        System.out.println("Cart");
        cartList.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
