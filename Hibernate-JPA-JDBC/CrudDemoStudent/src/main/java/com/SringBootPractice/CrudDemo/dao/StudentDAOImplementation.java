package com.SringBootPractice.CrudDemo.dao;

import com.SringBootPractice.CrudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO{

    // define entity manager
    private EntityManager entityManager;
    // injecting the entity manager using the CI
   @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implementing the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return  entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

       //creating the query for the quering the objects
        TypedQuery<Student> theQuery=  entityManager.createQuery("FROM Student order by lastName",Student.class);

        return  theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

       // writing the query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE last`Name=:theData",Student.class);
        //setting the parameters
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
       //retrieve the student
        Student thestudent=entityManager.find(Student.class,id);

        //delete the student
       entityManager.remove(thestudent);

    }
}
