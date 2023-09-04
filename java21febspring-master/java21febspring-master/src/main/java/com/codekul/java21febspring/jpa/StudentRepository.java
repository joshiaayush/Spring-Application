//package com.codekul.java21febspring.jpa;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface StudentRepository extends JpaRepository<Student,Long> {
//    Student findByName(String name);
//
//    List<Student> findByNameAndAddress(String name, String address);
//
//    List<Student> findByDobLessThan(LocalDate date);
//
//    List<Student> findByDobLessThanEqual(LocalDate date);
//
//    List<Student> findByDobBetween(LocalDate firstDate, LocalDate secondDate);
//}
