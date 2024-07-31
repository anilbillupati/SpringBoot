package com.SpringBootDemo.mycoolapp2.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControllerRest {
	
	@GetMapping("/")
	public String getName() {
		return "Im Aruna Billupati";
	}
	@GetMapping("/getwork")
	public String getWork() {
		return "Gen AI Engineer";
	}

}
