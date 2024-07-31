package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
    public FootBallCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Running and Jumbling EveryDay";
    }
}
