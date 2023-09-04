package com.codekul.java21febspring.onetomany.service;

import com.codekul.java21febspring.onetomany.dto.CustomerRequestDto;
import com.codekul.java21febspring.onetomany.entity.Customer;
import com.codekul.java21febspring.onetomany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerRequestDto customer) {
        var customer1 = new Customer();
        customer1.setProduct(customer.getProduct());
        customer1.setAddress(customer.getAddress());
        customer1.setName(customer.getName());
        customerRepository.save(customer1);
        return "customer saved.";
    }
}
