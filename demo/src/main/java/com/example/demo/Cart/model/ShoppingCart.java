package com.example.demo.Cart.model;
import com.example.demo.Cart.model.CartItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CartItem> items = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ShoppingCart(Integer id){
        this.id = id;
        cartItem = new ArrayList<>();
    }

    public ShoppingCart() {
        cartItem = new ArrayList<>();
    }

    public void addItem(CartItem item){
        cartItem.add(item);
    }

    public void removeItem(CartItem item, int newQuantity){
        cartItem.remove(item);
    }

    public void updateItemQuantity(CartItem item, int newQuantity){
        int index = cartItem.indexOf(item);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (CartItem item : cartItem){
            totalPrice = item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }


}
