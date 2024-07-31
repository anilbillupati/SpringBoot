package com.SpringBootPrac.SpringCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Bowling and Batting every day !!!!!!😊😊😊 ";
    }
}
