package com.example.demo.Cart.controller;

import com.example.demo.Cart.model.ShoppingCart;
import com.example.demo.Cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllCarts(){
        List<ShoppingCart> cart = cartService.getAllCarts();
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable Integer id) {
        ShoppingCart cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createCart(@RequestBody ShoppingCart cart) {
        ShoppingCart createdCart = cartService.createCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<ShoppingCart> updateCart(@PathVariable Long id, @RequestBody ShoppingCart cart) {
//        ShoppingCart updatedCart = cartService.addProductToCart(id, cart);
//        return ResponseEntity.ok(updatedCart);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
//        cartService.removeProductFromCart(id);
//        return ResponseEntity.noContent().build();
//    }
}
