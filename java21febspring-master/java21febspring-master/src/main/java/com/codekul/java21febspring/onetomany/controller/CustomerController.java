package com.codekul.java21febspring.onetomany.controller;

import com.codekul.java21febspring.onetomany.dto.CustomerRequestDto;
import com.codekul.java21febspring.onetomany.repository.CustomerRepository;
import com.codekul.java21febspring.onetomany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("save")
    public String saveCustomer(@RequestBody CustomerRequestDto customer) {
        return productService.saveCustomer(customer);
    }

    @GetMapping("getCustomer")
    public List<Map<String, String>> getCustomer() {
        return customerRepository.listOfCustomer();
    }

    @GetMapping("getCustomerById")
    public Map<String, String> getCustomerById(@RequestParam Long id) {
        return customerRepository.getCustById(id);
    }

}

/**
 *
 * {
 *
 *     "product": [
 *         {
 *             "pName": "Fan",
 *             "price": 66.0
 *         },
 *         {
 *             "pName": "AC",
 *             "price": 664.0
 *         }
 *     ],
 *     "name": "Jeevan",
 *     "address": "Mumabi"
 * }
 */