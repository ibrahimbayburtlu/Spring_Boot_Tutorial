package com.ibrahimbayburtlu.springboot.crudDemo.service;

import com.ibrahimbayburtlu.springboot.crudDemo.dao.StudentDAO;
import com.ibrahimbayburtlu.springboot.crudDemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIml implements StudentService{

    // add studentDAO for database transactional

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceIml(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = Optional.ofNullable(studentDAO.findById(theId));

        Student theStudent = null;
        if (result.isPresent()){
            theStudent = result.get();
        }else {
            throw new RuntimeException("Did not find student id - "+ theId);
        }
        return theStudent;
    }

    @Override
    @Transactional
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentDAO.deleteById(theId);
    }
}
