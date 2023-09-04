package com.codekul.java21febspring.onetomany.service;

import com.codekul.java21febspring.onetomany.dto.CustomerRequestDto;
import com.codekul.java21febspring.onetomany.entity.Customer;

public interface ProductService {

    String saveCustomer(CustomerRequestDto customer);
}
