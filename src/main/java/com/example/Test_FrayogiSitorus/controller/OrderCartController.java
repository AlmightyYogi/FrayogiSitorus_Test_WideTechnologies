package com.example.Test_FrayogiSitorus.controller;

import com.example.Test_FrayogiSitorus.model.OrderCart;
import com.example.Test_FrayogiSitorus.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-carts")
public class OrderCartController {

    @Autowired
    private OrderCartService orderCartService;

    @PostMapping
    public ResponseEntity<OrderCart> addOrderCart(@RequestBody OrderCart orderCart) {
        OrderCart savedCart = orderCartService.addItemsToCart(orderCart);
        return ResponseEntity.ok(savedCart);
    }
}