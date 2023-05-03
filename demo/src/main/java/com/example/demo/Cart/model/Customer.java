package com.example.demo.Cart.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String userRole;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private ShoppingCart cart;

    public Customer(Integer id, String username, String userRole, String firstName, String lastName, String password, ShoppingCart cart) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.cart = cart;
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ShoppingCart getShoppingCart (){
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart){
        this.cart = cart;
    }



}



