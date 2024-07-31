package com.SpringBoot.RESTAPI.RestAPIPractice.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobalExceptionHandleController {
    //adding the exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        //create the response entity
        StudentErrorResponse err= new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(e.getMessage());
        err.setTimesTamp(System.currentTimeMillis());
        //return the error response entity
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
    //handling the other edge case errors in the code

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException2(Exception e){
        //create error response
        StudentErrorResponse err= new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Enter the int value only not the String value ");
        err.setTimesTamp(System.currentTimeMillis());
        //return the error response entity
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
