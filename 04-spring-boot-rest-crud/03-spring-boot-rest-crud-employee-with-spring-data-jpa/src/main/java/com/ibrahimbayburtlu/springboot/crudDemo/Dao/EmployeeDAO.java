package com.ibrahimbayburtlu.springboot.crudDemo.Dao;

import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
