package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class KabaddiCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Exercise and Food will improve muscle Growth";
    }
}
