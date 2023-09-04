package com.codekul.java21febspring.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CoursesRepository coursesRepository;

    @PostMapping("saveCourse")
    private Courses saveCourse(@RequestBody Courses courses){
    return coursesRepository.save(courses);
    }

}
