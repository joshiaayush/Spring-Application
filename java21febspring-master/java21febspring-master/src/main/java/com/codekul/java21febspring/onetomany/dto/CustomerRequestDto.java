package com.codekul.java21febspring.onetomany.dto;

import com.codekul.java21febspring.onetomany.entity.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {

    private String name;

    private String address;

    private List<Product> product;

}
