package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.MultiTenantDashboardResponse;
import com.rapido.platformservice.service.MultiTenantDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiTenantDashboardController {

    private final MultiTenantDashboardService service;

    public MultiTenantDashboardController(
            MultiTenantDashboardService service) {
        this.service = service;
    }

    @GetMapping("/tenant/dashboard")
    public MultiTenantDashboardResponse dashboard() {
        return service.getTenantDashboard();
    }
}