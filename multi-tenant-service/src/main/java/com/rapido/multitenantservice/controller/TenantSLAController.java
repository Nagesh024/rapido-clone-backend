package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantSLARequest;
import com.rapido.multitenantservice.entity.TenantSLA;
import com.rapido.multitenantservice.service.TenantSLAService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/sla")
public class TenantSLAController {

    private final TenantSLAService service;

    public TenantSLAController(
            TenantSLAService service) {
        this.service = service;
    }

    @PostMapping
    public TenantSLA createSLA(
            @RequestBody TenantSLARequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<TenantSLA> getSLAs() {

        return service.getAll(
                TenantContext.getTenantId());
    }
}