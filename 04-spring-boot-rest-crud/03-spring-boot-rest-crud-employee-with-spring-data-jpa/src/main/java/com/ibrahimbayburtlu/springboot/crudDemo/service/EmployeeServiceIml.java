package com.ibrahimbayburtlu.springboot.crudDemo.service;

import com.ibrahimbayburtlu.springboot.crudDemo.Dao.EmployeeDAO;
import com.ibrahimbayburtlu.springboot.crudDemo.Dao.EmployeeDAOJpaImpl;
import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIml implements EmployeeService{

    // create EmployeeDAO
    private EmployeeDAO employeeDAO;

    // constructor injection
    @Autowired
    public EmployeeServiceIml(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
