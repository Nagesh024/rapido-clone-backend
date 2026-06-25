package com.rapido.platformengineering.compliance.controller;

import com.rapido.platformengineering.compliance.entity.ComplianceCheck;
import com.rapido.platformengineering.compliance.service.ComplianceCheckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compliance")
public class ComplianceCheckController {

    private final ComplianceCheckService service;

    public ComplianceCheckController(
            ComplianceCheckService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceCheck create(
            @RequestBody ComplianceCheck check) {

        return service.save(check);
    }

    @GetMapping
    public List<ComplianceCheck> getAll() {

        return service.findAll();
    }
}