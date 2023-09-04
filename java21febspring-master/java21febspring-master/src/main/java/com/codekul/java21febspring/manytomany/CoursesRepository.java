package com.codekul.java21febspring.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
}
