package com.codekul.java21febspring.onetoone.controller;

import com.codekul.java21febspring.onetoone.model.Address;
import com.codekul.java21febspring.onetoone.model.Employee;
import com.codekul.java21febspring.onetoone.repository.AddressRepository;
import com.codekul.java21febspring.onetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
       Employee employee1 = new Employee();
       employee1.setName(employee.getName());
       employee1.setMobileNumber(employee.getMobileNumber());

        Address address = new Address();
        address.setCity(employee.getAddress().getCity());
        address.setFlatNumber(employee.getAddress().getFlatNumber());
        address.setStreetName(employee.getAddress().getStreetName());
        address.setEmployee(employee1);

        employee1.setAddress(address);

        employeeRepository.save(employee1);
        addressRepository.save(address);
        return "employee saved ...";
    }
}
