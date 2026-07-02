package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.SocDashboardResponse;
import com.rapido.platformservice.service.SocDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocDashboardController {

    private final SocDashboardService service;

    public SocDashboardController(SocDashboardService service) {
        this.service = service;
    }

    @GetMapping("/soc/dashboard")
    public SocDashboardResponse dashboard() {
        return service.getDashboard();
    }
}