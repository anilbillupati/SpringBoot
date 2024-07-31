package com.RestCrudAPI.RestAPIEmployee.rest;

import com.RestCrudAPI.RestAPIEmployee.dao.EmployeeDAO;
import com.RestCrudAPI.RestAPIEmployee.entity.Employee;
import com.RestCrudAPI.RestAPIEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // getting the employee based on the id api/employee/{employeeId}
   @GetMapping("/employees/{employeeId}")
      public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findById(employeeId);
        if(theEmployee==null) {
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        return theEmployee;
      }

      //post the data // adding the employee into the table
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee ){

        theEmployee.setId(0);
        Employee newEmployee = employeeService.save(theEmployee) ;
        return newEmployee;

    }
    // updating the value tha is in the databse
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        //saving the employee
        Employee newEmployee = employeeService.save(theEmployee);
        return newEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId)
    {
        // find the employee by id
        Employee deletingEmployee=employeeService.findById(employeeId);
        //exception handling here
        if(deletingEmployee==null){
            throw  new RuntimeException("the id id not found "+employeeId);
        }
        //delete the id
       employeeService.deleteById(employeeId);
        //return the id
        return "the deleted employee id is :"+employeeId;
    }

}
