package com.rapido.adminservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TracingTestController {

    @GetMapping("/trace/ping")
    public String tracePing() {
        return "Admin Service Ping Successful";
    }
}