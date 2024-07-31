package com.RestCrudAPI.RestAPIEmployee.dao;

import com.RestCrudAPI.RestAPIEmployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
