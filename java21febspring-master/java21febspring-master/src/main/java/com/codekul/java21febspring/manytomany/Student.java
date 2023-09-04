package com.codekul.java21febspring.manytomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long mobileNumber;

    @ManyToMany()
    @JoinTable(name = "stud_courses",
            joinColumns ={@JoinColumn(name = "stud_id",referencedColumnName = "id")} ,
    inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")})
    private List<Courses> coursesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
