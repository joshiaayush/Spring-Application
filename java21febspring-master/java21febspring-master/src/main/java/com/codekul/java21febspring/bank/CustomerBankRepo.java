package com.codekul.java21febspring.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerBankRepo extends JpaRepository<CustomerBank, Long> {

    @Query(value = "select * from fn_get_accountnumber_count()", nativeQuery = true)
    Long getAccCount();

    @Query(value = "select * from fn_credit_debit(?1,?2,?3)", nativeQuery = true)
    Double creditOrDebit(String cbType, Double amount, String accNumber);
}
