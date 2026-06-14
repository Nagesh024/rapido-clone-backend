package com.rapido.rideservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs (important for curl/Postman)
            .csrf(csrf -> csrf.disable())

            // No session (microservice style)
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // allow actuator (optional)
                .requestMatchers("/actuator/**").permitAll()

                // allow all ride APIs (YOUR CASE)
                .requestMatchers("/rides/**").permitAll()
                .requestMatchers("/rides/matching/**").permitAll()

                // fallback
                .anyRequest().authenticated()
            );

        return http.build();
    }
}