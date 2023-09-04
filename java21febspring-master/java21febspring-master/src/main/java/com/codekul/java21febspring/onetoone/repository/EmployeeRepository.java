package com.codekul.java21febspring.onetoone.repository;

import com.codekul.java21febspring.onetoone.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
