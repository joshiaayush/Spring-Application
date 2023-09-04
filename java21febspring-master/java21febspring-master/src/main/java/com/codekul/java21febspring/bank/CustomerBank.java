package com.codekul.java21febspring.bank;

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
public class CustomerBank {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull(message = "name can not be null")
    private String name;

    @NotNull(message = "address cannot be null")
    private String address;

    @NotNull(message = "account number ")
    private String accountNumber;

    @NotNull(message = "balance can not be null")
    private Double balance = 0.0;
}
