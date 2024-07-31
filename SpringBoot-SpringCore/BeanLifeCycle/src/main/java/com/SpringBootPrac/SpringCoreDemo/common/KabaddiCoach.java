package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class KabaddiCoach implements Coach{
    public KabaddiCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Exercise and Food will improve muscle Growth";
    }
}
