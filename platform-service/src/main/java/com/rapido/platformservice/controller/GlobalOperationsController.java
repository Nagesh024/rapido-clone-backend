package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.GlobalOperationsResponse;
import com.rapido.platformservice.service.GlobalOperationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalOperationsController {

    private final GlobalOperationsService service;

    public GlobalOperationsController(GlobalOperationsService service) {
        this.service = service;
    }

    @GetMapping("/global/dashboard")
    public GlobalOperationsResponse dashboard() {
        return service.getDashboard();
    }
}