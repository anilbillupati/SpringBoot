package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Bowling and Batting every day !!!!!!😊😊😊 ";
    }
}
