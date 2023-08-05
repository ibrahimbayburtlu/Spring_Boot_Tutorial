package com.ibrahimbayburtlu.springboot.crudDemo.service;

import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;
import com.ibrahimbayburtlu.springboot.crudDemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIml implements EmployeeService{

    // create EmployeeRepository
    private EmployeeRepository employeeRepository;

    // constructor injection
    @Autowired
    public EmployeeServiceIml(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id-" + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
