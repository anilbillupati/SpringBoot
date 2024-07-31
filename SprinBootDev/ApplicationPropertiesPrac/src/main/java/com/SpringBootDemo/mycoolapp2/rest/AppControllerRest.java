package com.SpringBootDemo.mycoolapp2.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControllerRest {

	// injecting the properties values to the properties file
	@Value("${country.name}")
	private String countryName;
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	@Value("${captain.name}")
	private String captainName;

	@GetMapping("/getteaminfo")
	public String gameInfo(){
		return  countryName+"'s cricket Board BCCI appointed "+coachName+" as the new coach for "+teamName+" under the captaincy of "+captainName;
	}

	@GetMapping("/")
	public String getName() {
		return "Im Kalyani Bogala";
	}

	@GetMapping("/getwork")
	public String getWork() {
		return "Gen AI Engineer";
	}

	@GetMapping("/play")
	public String getGame() {
		return "Good Cricket All rounder";
	}

}
