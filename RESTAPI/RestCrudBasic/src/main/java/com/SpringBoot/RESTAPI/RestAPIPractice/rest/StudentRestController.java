package com.SpringBoot.RESTAPI.RestAPIPractice.rest;

import com.SpringBoot.RESTAPI.RestAPIPractice.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    @PostConstruct
    public void loadData(){
        theStudents= new ArrayList<>();
        theStudents.add(new Student("Anil","Billupati"));
        theStudents.add(new Student("nani","bogala"));
        theStudents.add(new Student("Krishna","tirumuru"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;

    }
    // defining the end point /student/{studentid}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //checking the student id against the list size
        if((studentId>=theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found"+studentId);
        }
        return theStudents.get(studentId);
    }
}
