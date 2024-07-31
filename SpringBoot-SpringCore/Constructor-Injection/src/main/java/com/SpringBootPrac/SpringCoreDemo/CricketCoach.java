package com.SpringBootPrac.SpringCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice Bowling and Batting every day !!!!!! ";
    }
}
