package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.SiemDashboardResponse;
import com.rapido.platformservice.service.SiemPlatformService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiemPlatformController {

    private final SiemPlatformService service;

    public SiemPlatformController(SiemPlatformService service) {
        this.service = service;
    }

    @GetMapping("/siem/dashboard")
    public SiemDashboardResponse dashboard() {
        return service.getDashboard();
    }
}