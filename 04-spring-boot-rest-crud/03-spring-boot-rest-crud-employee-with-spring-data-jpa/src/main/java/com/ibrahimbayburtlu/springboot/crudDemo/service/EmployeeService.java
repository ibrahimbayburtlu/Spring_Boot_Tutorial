package com.ibrahimbayburtlu.springboot.crudDemo.service;


import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
