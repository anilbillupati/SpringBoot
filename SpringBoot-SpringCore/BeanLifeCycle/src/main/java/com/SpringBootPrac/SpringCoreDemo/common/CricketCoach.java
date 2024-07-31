package com.SpringBootPrac.SpringCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("The Constructor is:"+getClass().getSimpleName());
    }
    // defining the postConstruct init method
    @PostConstruct
    public void  creatingBean(){
        System.out.println("creating the init method for "+getClass().getSimpleName());
    }
    //defining the destroy method
    @PreDestroy
    public void  cleaningBean(){
        System.out.println("cleaning the init method for "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Bowling and Batting every day !!!!!!😊😊😊 ";
    }
}
