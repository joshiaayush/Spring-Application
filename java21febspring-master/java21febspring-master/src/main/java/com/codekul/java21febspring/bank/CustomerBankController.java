package com.codekul.java21febspring.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerBankController {

    @Autowired
    private CustomerBankRepo customerBankRepo;

    @PostMapping("saveCustomer")
    private CustomerBank saveCustomer(@RequestBody CustomerBank customerBank) {
        var customer = new CustomerBank();
        customer.setName(customerBank.getName());
        customer.setAddress(customerBank.getAddress());
        Long acc = customerBankRepo.getAccCount();
        customer.setAccountNumber(String.format("%010d", ++acc));
        customer.setBalance(customerBank.getBalance());
        return customerBankRepo.save(customer);
    }

    @PostMapping("creditdebit")
    private Double creditOrDebit(@RequestBody CreditDebitDto creditDebitDto){
        return customerBankRepo.creditOrDebit(creditDebitDto.getType(), creditDebitDto.getAmount(), creditDebitDto.getAccountNumber());
    }

}

/**
 * CREATE OR REPLACE FUNCTION public.fn_get_accountnumber_count()
 *     RETURNS TABLE(accCount bigint)
 *     LANGUAGE 'plpgsql'
 *     COST 100
 *     VOLATILE PARALLEL UNSAFE
 *     ROWS 1000
 *
 * AS $BODY$
 *
 * begin
 * 	return query select count(*) from customer_bank;
 *     end;
 * $BODY$;
 *
 * select * from fn_get_accountnumber_count();
 */

/*
 *
 * select * from fn_credit_debit('Debit',2000,'0000000003')
 *
 * CREATE OR REPLACE FUNCTION public.fn_credit_debit(cbtype character varying,amount double precision,accountNumber character varying)
 *     RETURNS TABLE(_balance double precision)
 *     LANGUAGE 'plpgsql'
 *     COST 100
 *     VOLATILE PARALLEL UNSAFE
 *     ROWS 1000
 *
 * AS $BODY$
 *
 * begin
 * 	if(cbtype ='Credit') then
 * 	return query update  customer_bank set balance = balance+amount where account_number =accountNumber returning balance;
 * 	else
 * 	return query update  customer_bank set balance = balance-amount where account_number =accountNumber returning balance;
 * 	end if;
 *     end;
 * $BODY$;
 */