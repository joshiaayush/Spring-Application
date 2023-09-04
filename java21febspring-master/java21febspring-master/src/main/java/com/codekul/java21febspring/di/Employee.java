package com.codekul.java21febspring.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class Employee {

    private Long id;

    private String name;

    private String address;

    public Employee() {
        System.out.println("In employee constructor");
    }

    public void emp(){
        System.out.println("In employee");
    }
}
