package com.RestCrudAPI.RestAPIEmployee.service;

import com.RestCrudAPI.RestAPIEmployee.dao.EmployeeRepository;
import com.RestCrudAPI.RestAPIEmployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements  EmployeeService {

//     private EmployeeDAO employeeDAO;

    public EmployeeRepository employeeRepository;

     @Autowired
     public EmployeeServiceImplementation(EmployeeRepository theEmployeeRepository){
         employeeRepository=theEmployeeRepository;
     }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result= employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
           theEmployee= result.get();
        }else{
            throw new RuntimeException("the is not present"+theId);
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
