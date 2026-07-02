package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.PlatformSlaResponse;
import com.rapido.platformservice.service.PlatformSlaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformSlaController {

    private final PlatformSlaService service;

    public PlatformSlaController(PlatformSlaService service) {
        this.service = service;
    }

    @GetMapping("/platform/sla")
    public PlatformSlaResponse getPlatformSla() {
        return service.getPlatformSla();
    }
}