package com.codekul.java21febspring.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudController {


    @Autowired
    private StudRepo studRepo;

    @PostMapping("saveStudent")
    public String saveStudent(@RequestBody Student student){
        studRepo.save(student);
        return "student saved.";
    }
}
/**
 *
 * {
 *     "name":"ABC",
 *     "mobileNumber":923,
 *     "coursesList":[
 *         {
 *             "id":1
 *         },
 *         {
 *             "id":2
 *         }
 *     ]
 * }
 */