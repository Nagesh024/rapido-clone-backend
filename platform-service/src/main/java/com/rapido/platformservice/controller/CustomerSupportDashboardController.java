package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.CustomerSupportDashboardResponse;
import com.rapido.platformservice.service.CustomerSupportDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerSupportDashboardController {

    private final CustomerSupportDashboardService service;

    public CustomerSupportDashboardController(
            CustomerSupportDashboardService service) {
        this.service = service;
    }

    @GetMapping("/support/dashboard")
    public CustomerSupportDashboardResponse dashboard() {
        return service.getDashboard();
    }
}