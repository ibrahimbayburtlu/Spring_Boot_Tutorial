package com.ibrahimbayburtlu.cruddemo.dao;

import com.ibrahimbayburtlu.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
}
