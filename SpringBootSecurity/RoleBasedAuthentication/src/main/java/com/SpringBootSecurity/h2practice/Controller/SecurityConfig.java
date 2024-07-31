package com.SpringBootSecurity.h2practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());
        //  http.formLogin(withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults());
        http.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    //to implement multiple people authentication we need userDetails service basically it is an interface

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("anil")
                .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();
        UserDetails admin=User.withUsername("abdul")
                .password(passwordEncoder().encode("adminpassword"))
                .roles("ADMIN")
                .build();

        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.createUser(user1);
        jdbcUserDetailsManager.createUser(admin);
       // return new InMemoryUserDetailsManager(user1,admin);

        return jdbcUserDetailsManager;
    }
    // adding the encrypting to the passwords so that they don't visible as the plain texts in the db table
        @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }


}
