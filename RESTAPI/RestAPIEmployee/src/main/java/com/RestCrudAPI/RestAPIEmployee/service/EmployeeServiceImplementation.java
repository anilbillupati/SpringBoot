package com.RestCrudAPI.RestAPIEmployee.service;

import com.RestCrudAPI.RestAPIEmployee.dao.EmployeeDAO;
import com.RestCrudAPI.RestAPIEmployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImplementation implements  EmployeeService {

     private EmployeeDAO employeeDAO;

     @Autowired
     public EmployeeServiceImplementation(EmployeeDAO theEmployeeDAO){
         employeeDAO=theEmployeeDAO;
     }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
         employeeDAO.deleteById(theId);
    }

}
