package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.BrandingRequest;
import com.rapido.multitenantservice.entity.BrandingConfiguration;
import com.rapido.multitenantservice.service.BrandingConfigurationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/branding")
public class BrandingConfigurationController {

    private final BrandingConfigurationService service;

    public BrandingConfigurationController(
            BrandingConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public BrandingConfiguration createBranding(
            @RequestBody BrandingRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @PutMapping
    public BrandingConfiguration updateBranding(
            @RequestBody BrandingRequest request) {

        return service.update(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public BrandingConfiguration getBranding() {

        return service.get(
                TenantContext.getTenantId());
    }
}