  package com.SpringBootSecurity.JWTDemo.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;

public class SecurityConfiguration extends WebSecurityConfigurer {

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {

    }
}
