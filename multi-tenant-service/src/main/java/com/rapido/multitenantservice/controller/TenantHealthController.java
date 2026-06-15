package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantHealthRequest;
import com.rapido.multitenantservice.entity.TenantHealth;
import com.rapido.multitenantservice.service.TenantHealthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/health")
public class TenantHealthController {

    private final TenantHealthService service;

    public TenantHealthController(
            TenantHealthService service) {
        this.service = service;
    }

    @PostMapping
    public TenantHealth saveHealth(
            @RequestBody TenantHealthRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public TenantHealth getHealth() {

        return service.get(
                TenantContext.getTenantId());
    }
}