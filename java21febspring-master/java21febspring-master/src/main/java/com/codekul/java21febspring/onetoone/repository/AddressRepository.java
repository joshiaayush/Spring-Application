package com.codekul.java21febspring.onetoone.repository;

import com.codekul.java21febspring.onetoone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
