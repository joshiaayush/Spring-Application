package com.codekul.java21febspring.aop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name can not be null")
    private String name;

    @NotNull(message = "address cannot be null")
    private String address;

    @NotNull(message = "username cannot be null")
    private String userName;

    @NotNull(message = "password cannot be null")
    private String password;
}
