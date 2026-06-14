package com.rapido.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationHealthController {

    @GetMapping("/notifications/health")
    public String health() {
        return "Notification Service Running Successfully";
    }
}