package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Running and Jumbling EveryDay";
    }
}
