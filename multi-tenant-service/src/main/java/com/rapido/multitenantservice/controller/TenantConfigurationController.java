package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantConfigurationRequest;
import com.rapido.multitenantservice.entity.TenantConfiguration;
import com.rapido.multitenantservice.service.TenantConfigurationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/config")
public class TenantConfigurationController {

    private final TenantConfigurationService service;

    public TenantConfigurationController(
            TenantConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public TenantConfiguration saveConfiguration(
            @RequestBody TenantConfigurationRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public TenantConfiguration getConfiguration() {

        return service.get(
                TenantContext.getTenantId());
    }
}