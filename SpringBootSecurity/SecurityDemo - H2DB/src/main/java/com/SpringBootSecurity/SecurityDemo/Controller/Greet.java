package com.SpringBootSecurity.SecurityDemo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Greet {

    @GetMapping("/hello")
    public String message(){
        return "Hello Anil Kumar Billupati ";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/work")
    public String employeeWork(){
        return "I'm Backend Developer ";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String companyAdmin(){
        return "Back End Code at Fission Labs ";
    }

}
