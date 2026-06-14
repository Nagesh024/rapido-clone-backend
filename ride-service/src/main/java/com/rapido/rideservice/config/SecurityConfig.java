package com.rapido.rideservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ❌ CSRF disabled for APIs
            .csrf(csrf -> csrf.disable())

            // ❌ Stateless REST APIs
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // 🔐 SECURITY RULES
            .authorizeHttpRequests(auth -> auth

                // public endpoints
                .requestMatchers("/api/rides/health").permitAll()

                // secure all ride APIs
                .requestMatchers("/api/rides/**").authenticated()

                .anyRequest().denyAll()
            );

        return http.build();
    }
}