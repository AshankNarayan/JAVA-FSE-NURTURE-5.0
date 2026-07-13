package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring HttpSecurity filter chain...");
        
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/authenticate").permitAll() // Permit authentication endpoint to handle basic auth header manually
            .anyRequest().authenticated()
            .and()
            .httpBasic(); // Optional basic auth configuration for standard requests

        LOGGER.info("HttpSecurity filter chain configured successfully.");
        return http.build();
    }
}
