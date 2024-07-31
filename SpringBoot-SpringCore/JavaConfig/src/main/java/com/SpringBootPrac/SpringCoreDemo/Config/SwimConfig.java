package com.SpringBootPrac.SpringCoreDemo.Config;

import com.SpringBootPrac.SpringCoreDemo.common.Coach;
import com.SpringBootPrac.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {


    //giving the custom bean id to use
    @Bean("beanid")
    public Coach swimCoach(){
        return new SwimCoach();

    }
}
