package com.example.sprboot;

import com.example.sprboot.model.Cart;
import com.example.sprboot.model.Product;
import com.example.sprboot.repository.ProductRepository;
import com.example.sprboot.service.CartService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SprBootApplication {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private Cart cart;

    public static void main(String[] args) {
        SpringApplication.run(SprBootApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void inited() {
        showRepository(productRepository);
        buyStage(cart, productRepository, cartService);
    }

    public static boolean buyStage(Cart cart, ProductRepository productRepository,
                                   CartService cartService) {

        Scanner scanner = new Scanner(System.in);
        int answer;

        System.out.println("Enter 1 to add product or 2 to remove product");
        answer = scanner.nextInt();
        if (answer == 1) {
            int id;
            System.out.println("Enter id of product");
            id = scanner.nextInt();
            addProductToCart(cart, productRepository, cartService, id);
        }
        if (answer == 2) {
            int id;
            System.out.println("Enter id of product");
            id = scanner.nextInt();
            removeProductFromCart(cart, productRepository, cartService, id);
        }
        showCart(cart);

        System.out.println("Enter 1 to finish, 2 to resume or 3 to create new cart");
        answer = scanner.nextInt();
        if (answer == 1) {
            return true;
        }
        if (answer == 2) {
            buyStage(cart, productRepository, cartService);
        }
        if (answer == 3) {
            buyStage(createCart(), productRepository, cartService);
        }
        return true;
    }

    @Bean
    public static Cart createCart() {
        List<Product> list = new ArrayList<>();
        return new Cart(list);
    }

    public static void showRepository(ProductRepository productRepository) {
        productRepository.printAllProducts();
    }

    public static void showCart(Cart cart) {
        cart.printCartList();
    }

    public static void addProductToCart(Cart cart, ProductRepository productRepository,
                                        CartService cartService, Integer id) {
        cartService.addProductById(productRepository, cart, id);
    }

    public static void removeProductFromCart(Cart cart, ProductRepository productRepository,
                                             CartService cartService, Integer id) {
        cartService.removeProductById(productRepository, cart, id);
    }
}
