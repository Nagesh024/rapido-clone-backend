package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.MonitoringDashboardResponse;
import com.rapido.platformengineering.service.MonitoringService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoring")
public class MonitoringController {

    private final MonitoringService service;

    public MonitoringController(
            MonitoringService service) {

        this.service = service;
    }

    @GetMapping("/dashboard")
    public MonitoringDashboardResponse dashboard() {

        return service.getDashboard();
    }
}