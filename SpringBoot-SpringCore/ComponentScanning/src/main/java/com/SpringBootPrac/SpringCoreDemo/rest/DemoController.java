package com.SpringBootPrac.SpringCoreDemo.rest;

import com.SpringBootPrac.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	//defining the private field to create the dependency 
	private Coach myCoach;
	
	//creating the constructor for injection
	
	@Autowired   // tells Spring to inject the dependency   //if there is only one constructor then no need to mention @autowired
	public DemoController(Coach theCoach) {
		myCoach=theCoach;
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	

}
