package com.codekul.java21febspring.onetomany.repository;

import com.codekul.java21febspring.onetomany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select id,name,address from customer",nativeQuery = true)
    List<Map<String,String>> listOfCustomer();
    @Query(value = "select name,address from customer where id = ?1",nativeQuery = true)
    Map<String,String> getCustById(Long id);
}
