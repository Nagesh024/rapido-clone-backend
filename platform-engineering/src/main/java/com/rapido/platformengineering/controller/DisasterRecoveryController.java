package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.DisasterRecoveryResponse;
import com.rapido.platformengineering.service.DisasterRecoveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recovery")
public class DisasterRecoveryController {

    private final DisasterRecoveryService service;

    public DisasterRecoveryController(
            DisasterRecoveryService service) {

        this.service = service;
    }

    @GetMapping
    public DisasterRecoveryResponse status() {

        return service.getStatus();
    }
}