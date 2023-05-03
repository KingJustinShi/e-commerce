package com.example.demo.Cart.service;

import com.example.demo.Cart.model.CartItem;
import com.example.demo.Cart.model.Product;
import com.example.demo.Cart.model.ShoppingCart;
import com.example.demo.Cart.repository.CartItemRepository;
import com.example.demo.Cart.repository.CartRepository;
import com.example.demo.Cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<ShoppingCart> getAllCarts(){
        return cartRepository.findAll();
    }
    public ShoppingCart getCartById(Integer id) {
        Optional<ShoppingCart> cart = cartRepository.findById(id);
        return cart.orElse(null);
    }

    public ShoppingCart createCart() {
        ShoppingCart cart = new ShoppingCart();
        return cartRepository.save(cart);
    }

    public ShoppingCart createCart(ShoppingCart cart) {
        return cartRepository.save(cart);
    }
    public ShoppingCart addProductToCart(Integer cartId, Integer productId) {
        Optional<ShoppingCart> optionalCart = cartRepository.findById(cartId);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalCart.isPresent() && optionalProduct.isPresent()) {
            ShoppingCart cart = optionalCart.get();
            Product product = optionalProduct.get();
            CartItem cartItem = new CartItem(product, cart, 1);
            cart.getCartItem().add(cartItem);
            cartItemRepository.save(cartItem);
            return cartRepository.save(cart);
        }
        return null;
    }
    public ShoppingCart removeProductFromCart(Integer cartId, Integer productId) {
        Optional<ShoppingCart> optionalCart = cartRepository.findById(cartId);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalCart.isPresent() && optionalProduct.isPresent()) {
            ShoppingCart cart = optionalCart.get();
            Product product = optionalProduct.get();
            CartItem cartItem = cart.getCartItem().stream()
                    .filter(item -> item.getProduct().getId().equals(productId))
                    .findFirst()
                    .orElse(null);
            if (cartItem != null) {
                cart.getCartItem().remove(cartItem);
                cartItemRepository.delete(cartItem);
            }
            return cartRepository.save(cart);
        }
        return null;
    }


}
