package com.rapido.platformservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.rapido.platformservice.entity.TenantConfiguration;
import com.rapido.platformservice.service.TenantConfigurationService;

@RestController
@RequestMapping("/api/tenant-configurations")
public class TenantConfigurationController {

    private final TenantConfigurationService service;

    public TenantConfigurationController(TenantConfigurationService service) {
        this.service = service;
    }

    @GetMapping
    public List<TenantConfiguration> getAllTenantConfigurations() {
        return service.getAllTenantConfigurations();
    }

    @PostMapping
    public TenantConfiguration createTenantConfiguration(@RequestBody TenantConfiguration tenantConfiguration) {
        return service.saveTenantConfiguration(tenantConfiguration);
    }
}