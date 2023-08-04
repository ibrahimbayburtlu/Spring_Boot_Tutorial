package com.ibrahimbayburtlu.rest;

import com.ibrahimbayburtlu.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents = new ArrayList<>();

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Fatih","Terim"));
        theStudents.add(new Student("Leo","Messi"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ... keep it simple for now
        return theStudents.get(studentId);
    }
}
