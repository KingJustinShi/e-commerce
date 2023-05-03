package com.example.demo.Cart.service;

import com.example.demo.Cart.model.Product;
import com.example.demo.Cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product productInfo){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product newProduct = optionalProduct.get();
            newProduct.setName(productInfo.getName());
            newProduct.setPrice(productInfo.getPrice());
            return productRepository.save(newProduct);
        }
        return null;
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }



}
