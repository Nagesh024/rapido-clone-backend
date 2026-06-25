package com.rapido.platformengineering.kpi.controller;

import com.rapido.platformengineering.kpi.entity.EngineeringKPI;
import com.rapido.platformengineering.kpi.service.EngineeringKPIService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kpi")
public class EngineeringKPIController {

    private final EngineeringKPIService service;

    public EngineeringKPIController(
            EngineeringKPIService service) {

        this.service = service;
    }

    @PostMapping
    public EngineeringKPI create(
            @RequestBody EngineeringKPI kpi) {

        return service.save(kpi);
    }

    @GetMapping
    public List<EngineeringKPI> getAll() {

        return service.findAll();
    }
}