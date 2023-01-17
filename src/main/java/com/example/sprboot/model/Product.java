package com.example.sprboot.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private int id;
    private String name;
    private BigDecimal price;

}
