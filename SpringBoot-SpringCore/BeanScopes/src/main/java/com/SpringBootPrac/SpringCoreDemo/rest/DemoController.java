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
	private Coach anotherCoach;
	
	//creating the constructor for injection

    @Autowired
	public DemoController(@Qualifier("cricketCoach") Coach theCoach  ,@Qualifier ("cricketCoach") Coach theanotherCoach){
		System.out.println("The Constructor is:"+getClass().getSimpleName());
		myCoach=theCoach;
		anotherCoach=theanotherCoach;
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/testscope")
	public String Check(){
		return "the scope of bean is "+(myCoach==anotherCoach);
	}

}
