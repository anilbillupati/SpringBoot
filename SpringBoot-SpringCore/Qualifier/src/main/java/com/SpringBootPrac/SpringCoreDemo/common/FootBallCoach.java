package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Running and Jumbling EveryDay";
    }
}
