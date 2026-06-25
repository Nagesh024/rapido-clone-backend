package com.rapido.platformengineering.readiness.controller;

import com.rapido.platformengineering.readiness.entity.ProductionReadinessAssessment;
import com.rapido.platformengineering.readiness.service.ProductionReadinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/readiness")
public class ProductionReadinessController {

    private final ProductionReadinessService service;

    public ProductionReadinessController(
            ProductionReadinessService service) {
        this.service = service;
    }

    @PostMapping
    public ProductionReadinessAssessment create(
            @RequestBody ProductionReadinessAssessment assessment) {

        return service.save(assessment);
    }

    @GetMapping
    public List<ProductionReadinessAssessment> getAll() {

        return service.findAll();
    }
}