package com.RestCrudAPI.RestAPIEmployee.dao;

import com.RestCrudAPI.RestAPIEmployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOjpaImplementation implements EmployeeDAO{

    //generate the entity manager
    private EntityManager entityManager;

    //injecting using the CI
    @Autowired
    public EmployeeDAOjpaImplementation(EntityManager theentityManager){
        entityManager=theentityManager;
    }
    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

        // store the employee
        List<Employee> employees=theQuery.getResultList();
        //return the list of employees

        return employees;

    }

    @Override
    public Employee findById(int theId) {
        //get the employee
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save the employee
        Employee newemployee= entityManager.merge(theEmployee);
        return newemployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);

    }
}
