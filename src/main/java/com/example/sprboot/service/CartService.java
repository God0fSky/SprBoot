package com.example.sprboot.service;

import com.example.sprboot.model.Cart;
import com.example.sprboot.model.Product;
import com.example.sprboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private Cart cart;
    private ProductRepository productRepository;

    public void addProductById(ProductRepository productRepository, Cart cart, Integer id) {

        if (productRepository == null || cart == null || id == null) {
            System.out.println("Class CartService, method addProductById, nullPointerException");
            return;
        }

        for (Product product : productRepository.getProductList()) {
            if (id.equals(product.getId())) {
                cart.getCartList().add(product);
            }
        }

    }

    public void removeProductById(ProductRepository productRepository, Cart cart, Integer id) {

        if (productRepository == null || cart == null || id == null) {
            System.out.println("Class CartService, method removeProductById, nullPointerException");
            return;
        }

        for (Product product : productRepository.getProductList()) {
            if (id.equals(product.getId())) {
                cart.getCartList().remove(product);
            }
        }

    }

}
