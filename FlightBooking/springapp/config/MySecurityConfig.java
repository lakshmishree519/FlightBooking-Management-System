package com.examly.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain makeSecurityFilterChain(HttpSecurity http) throws Exception{
        return http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth.anyRequest().permitAll())
        .build();

    }
}
