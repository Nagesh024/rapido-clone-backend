package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantDashboardResponse;
import com.rapido.multitenantservice.service.TenantDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantDashboardController {

    private final TenantDashboardService service;

    public TenantDashboardController(
            TenantDashboardService service) {
        this.service = service;
    }

    @GetMapping("/tenant/dashboard")
    public TenantDashboardResponse dashboard() {

        return service.getDashboard(
                TenantContext.getTenantId());
    }
}