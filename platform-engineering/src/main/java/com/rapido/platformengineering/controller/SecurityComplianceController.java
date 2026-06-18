package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.SecurityComplianceResponse;
import com.rapido.platformengineering.service.SecurityComplianceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityComplianceController {

    private final SecurityComplianceService service;

    public SecurityComplianceController(
            SecurityComplianceService service) {

        this.service = service;
    }

    @GetMapping("/compliance")
    public SecurityComplianceResponse compliance() {

        return service.getCompliance();
    }
}