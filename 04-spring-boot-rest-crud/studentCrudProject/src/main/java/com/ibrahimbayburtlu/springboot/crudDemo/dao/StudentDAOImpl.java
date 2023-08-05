package com.ibrahimbayburtlu.springboot.crudDemo.dao;

import com.ibrahimbayburtlu.springboot.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // create a entity manager
    private EntityManager entityManager;

    // constructor dependency injection entityManager
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student ",Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        //  return the results
        return students;
    }

    @Override
    public Student findById(int theId) {

        // get Student
        Student theStudent = entityManager.find(Student.class,theId);

        // return Student
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {
        Student dbStudent = entityManager.merge(theStudent);

        // return dbStudent
        return dbStudent;
    }

    @Override
    public void deleteById(int theId) {

        // find the Student by id
        Student theStudent = entityManager.find(Student.class,theId);

        // remove the Student
        entityManager.remove(theStudent);
    }
}
