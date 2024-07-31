package com.SpringBoot.RESTAPI.RestAPIPractice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// note :
    /// it is only for understanding and practice the postman not part of the actual code

@RestController
@RequestMapping("/test")
public class DemoRestController {

// add code for /hello end point
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!!!!!!!";
    }
}
