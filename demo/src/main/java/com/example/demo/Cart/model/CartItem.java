package com.example.demo.Cart.model;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private ShoppingCart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public CartItem(Product product, ShoppingCart cart, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.cart = cart;
    }

    public CartItem() {

    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }

    public ShoppingCart getCart() {
        return cart;
    }

}
