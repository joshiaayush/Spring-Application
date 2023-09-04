package com.codekul.java21febspring.bank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditDebitDto {

    private Double amount;

    private String accountNumber;

    private String type;
}
