package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.FeatureFlagRequest;
import com.rapido.multitenantservice.entity.FeatureFlag;
import com.rapido.multitenantservice.service.FeatureFlagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/features")
public class FeatureFlagController {

    private final FeatureFlagService service;

    public FeatureFlagController(
            FeatureFlagService service) {
        this.service = service;
    }

    @PostMapping
    public FeatureFlag saveFeatures(
            @RequestBody FeatureFlagRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public FeatureFlag getFeatures() {

        return service.get(
                TenantContext.getTenantId());
    }
}