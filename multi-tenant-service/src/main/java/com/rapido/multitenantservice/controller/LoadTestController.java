package com.rapido.multitenantservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoadTestController {

    
    @GetMapping("/load-test")
    public Map<String, String> test() {

        System.out.println("Load Test Request Received");

        return Map.of(
                "status",
                "SUCCESS");
    }
}