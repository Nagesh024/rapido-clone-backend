package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantComplianceRequest;
import com.rapido.multitenantservice.entity.TenantCompliance;
import com.rapido.multitenantservice.service.TenantComplianceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/compliance")
public class TenantComplianceController {

    private final TenantComplianceService service;

    public TenantComplianceController(
            TenantComplianceService service) {
        this.service = service;
    }

    @PostMapping
    public TenantCompliance saveCompliance(
            @RequestBody TenantComplianceRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<TenantCompliance> getCompliance() {

        return service.getAll(
                TenantContext.getTenantId());
    }
}