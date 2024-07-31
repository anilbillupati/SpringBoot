package com.RestCrudAPI.RestAPIEmployee.dao;

import com.RestCrudAPI.RestAPIEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
