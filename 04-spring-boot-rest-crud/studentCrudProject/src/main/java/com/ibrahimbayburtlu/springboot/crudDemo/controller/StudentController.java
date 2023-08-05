package com.ibrahimbayburtlu.springboot.crudDemo.controller;

import com.ibrahimbayburtlu.springboot.crudDemo.entity.Student;
import com.ibrahimbayburtlu.springboot.crudDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    // add studentService
    private StudentService studentService;

    // constructor set up dependency Injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // expose "/student" adn return a list of employees

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studendId}")
    public Student getStudent(@PathVariable int studendId){
        Student theStudent = studentService.findById(studendId);

        if (theStudent == null){
            throw new RuntimeException("Student id not found -" + studendId);
        }
        return theStudent;
    }

    @PostMapping("/students")
    public Student addStudent (@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateEmployee(@RequestBody Student theStudent){
        Student dbStudent = studentService.save(theStudent);
        return dbStudent;
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable int studentId){

        Student theStudent = studentService.findById(studentId);

        if (theStudent == null){
            throw new RuntimeException("Student id not found -"+studentId);
        }
        studentService.deleteById(studentId);

        return "Deleted student id -" + studentId;
    }
}
