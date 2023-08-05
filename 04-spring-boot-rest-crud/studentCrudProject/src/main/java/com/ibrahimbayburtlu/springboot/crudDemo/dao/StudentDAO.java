package com.ibrahimbayburtlu.springboot.crudDemo.dao;

import com.ibrahimbayburtlu.springboot.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
