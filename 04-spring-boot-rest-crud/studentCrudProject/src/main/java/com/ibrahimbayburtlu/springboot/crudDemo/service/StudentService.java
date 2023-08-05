package com.ibrahimbayburtlu.springboot.crudDemo.service;

import com.ibrahimbayburtlu.springboot.crudDemo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
