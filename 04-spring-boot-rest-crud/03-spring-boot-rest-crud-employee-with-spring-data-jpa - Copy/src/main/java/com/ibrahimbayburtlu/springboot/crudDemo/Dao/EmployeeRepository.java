package com.ibrahimbayburtlu.springboot.crudDemo.Dao;

import com.ibrahimbayburtlu.springboot.crudDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
