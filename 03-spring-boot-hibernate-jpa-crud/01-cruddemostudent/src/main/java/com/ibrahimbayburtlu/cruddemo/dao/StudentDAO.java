package com.ibrahimbayburtlu.cruddemo.dao;

import com.ibrahimbayburtlu.cruddemo.entity.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);
}
