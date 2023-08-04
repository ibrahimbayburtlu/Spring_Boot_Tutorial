package com.ibrahimbayburtlu.rest;

import com.ibrahimbayburtlu.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudent(){

        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Fatih","Terim"));
        theStudents.add(new Student("Leo","Messi"));
        return theStudents;
    }
}
