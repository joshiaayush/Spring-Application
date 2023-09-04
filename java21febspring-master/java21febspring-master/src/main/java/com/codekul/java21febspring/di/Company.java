package com.codekul.java21febspring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Company {

    private Long id;

    private String name;

    private String address;

    @Autowired
    private Employee employee; //wiring
//
//     @Autowired
//    private Employee employee1; //wiring

//    public void setEmployee(Employee employee) {//setter based injection
//        this.employee = employee;
//    }

//    public Company(Employee employee) {//constructor based injection
//        this.employee = employee;
//    }

    public void show(){
        employee.emp();
//        employee1.emp();
    }
}
