package com.example.demo.Cart.service;

import com.example.demo.Cart.model.Customer;
import com.example.demo.Cart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }


    public Customer updateCustomer(Integer id, Customer newCustomer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            Customer currCustomer = optionalCustomer.get();
            currCustomer.setFirstName(newCustomer.getFirstName());
            currCustomer.setLastName(newCustomer.getLastName());
            currCustomer.setUsername(newCustomer.getUsername());
            currCustomer.setPassword(newCustomer.getPassword());
            currCustomer.setShoppingCart(newCustomer.getShoppingCart());
            return customerRepository.save(currCustomer);
        }
        return null;
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

}
