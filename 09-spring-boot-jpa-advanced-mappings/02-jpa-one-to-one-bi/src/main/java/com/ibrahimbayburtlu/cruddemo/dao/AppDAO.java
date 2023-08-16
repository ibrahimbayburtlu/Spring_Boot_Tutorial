package com.ibrahimbayburtlu.cruddemo.dao;

import com.ibrahimbayburtlu.cruddemo.entity.Instructor;
import com.ibrahimbayburtlu.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
