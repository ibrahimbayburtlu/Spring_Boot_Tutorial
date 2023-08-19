package com.ibrahimbayburtlu.cruddemo.dao;

import com.ibrahimbayburtlu.cruddemo.entity.Course;
import com.ibrahimbayburtlu.cruddemo.entity.Instructor;
import com.ibrahimbayburtlu.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCourseByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
}
