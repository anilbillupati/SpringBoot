package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Forehand and Backhand";
    }
}
