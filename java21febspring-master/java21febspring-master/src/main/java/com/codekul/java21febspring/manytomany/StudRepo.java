package com.codekul.java21febspring.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudRepo extends JpaRepository<Student,Long> {
}
