package com.rapido.globalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GlobalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalServiceApplication.class, args);
    }
}