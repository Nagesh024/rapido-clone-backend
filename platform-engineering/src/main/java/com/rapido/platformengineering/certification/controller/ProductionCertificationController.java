package com.rapido.platformengineering.certification.controller;

import com.rapido.platformengineering.certification.entity.ProductionCertification;
import com.rapido.platformengineering.certification.service.ProductionCertificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/certification")
public class ProductionCertificationController {

    private final ProductionCertificationService service;

    public ProductionCertificationController(
            ProductionCertificationService service) {

        this.service = service;
    }

    @PostMapping
    public ProductionCertification create(
            @RequestBody ProductionCertification certification) {

        return service.save(certification);
    }

    @GetMapping
    public List<ProductionCertification> getAll() {

        return service.findAll();
    }
}