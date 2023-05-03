package com.example.demo.Cart.repository;

import com.example.demo.Cart.model.Customer;
import com.example.demo.Cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
