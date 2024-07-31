package com.SpringBootPrac.SpringCoreDemo.rest;

import com.SpringBootPrac.SpringCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	//defining the private field to create the dependency 
	private Coach myCoach;
	
	//creating the constructor for injection

    @Autowired
	public DemoController(@Qualifier("tennisCoach") Coach theCoach){
		myCoach=theCoach;
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	

}
