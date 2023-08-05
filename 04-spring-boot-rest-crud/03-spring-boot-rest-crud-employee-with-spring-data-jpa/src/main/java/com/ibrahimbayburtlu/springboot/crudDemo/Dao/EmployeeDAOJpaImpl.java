package com.ibrahimbayburtlu.springboot.crudDemo.Dao;

import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ",Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save or update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return dbEmployee
        return dbEmployee;

    }

    @Override
    public void deleteById(int theId) {

        // find the employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // remove the employee
        entityManager.remove(theEmployee);
    }
}
