package com.rapido.platformengineering.risk.controller;

import com.rapido.platformengineering.risk.entity.ArchitectureRisk;
import com.rapido.platformengineering.risk.service.ArchitectureRiskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/risks")
public class ArchitectureRiskController {

    private final ArchitectureRiskService service;

    public ArchitectureRiskController(
            ArchitectureRiskService service) {

        this.service = service;
    }

    @PostMapping
    public ArchitectureRisk create(
            @RequestBody ArchitectureRisk risk) {

        return service.save(risk);
    }

    @GetMapping
    public List<ArchitectureRisk> getAll() {

        return service.findAll();
    }
}