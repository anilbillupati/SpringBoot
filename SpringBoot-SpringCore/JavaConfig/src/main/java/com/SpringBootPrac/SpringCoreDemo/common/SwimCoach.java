package com.SpringBootPrac.SpringCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("inn the Constructor"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "need 1000m Swimming warmup each day ";
    }
}
