package com.rapido.platformengineering.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    @GetMapping
    public String templates() {

        return """
                spring-boot-service
                kafka-producer
                kafka-consumer
                rest-api-service
                scheduled-job-service
                """;
    }
}