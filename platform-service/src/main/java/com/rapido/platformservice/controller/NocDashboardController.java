package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.NocDashboardResponse;
import com.rapido.platformservice.service.NocDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NocDashboardController {

    private final NocDashboardService service;

    public NocDashboardController(NocDashboardService service) {
        this.service = service;
    }

    @GetMapping("/noc/dashboard")
    public NocDashboardResponse dashboard() {
        return service.getDashboard();
    }
}