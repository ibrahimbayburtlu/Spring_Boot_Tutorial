package com.ibrahimbayburtlu.springboot.crudDemo.Dao;

import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
