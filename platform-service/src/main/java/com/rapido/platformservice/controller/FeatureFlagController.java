package com.rapido.platformservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.rapido.platformservice.entity.FeatureFlag;
import com.rapido.platformservice.service.FeatureFlagService;

@RestController
@RequestMapping("/api/feature-flags")
public class FeatureFlagController {

    private final FeatureFlagService service;

    public FeatureFlagController(FeatureFlagService service) {
        this.service = service;
    }

    @GetMapping
    public List<FeatureFlag> getAllFeatureFlags() {
        return service.getAllFeatureFlags();
    }

    @PostMapping
    public FeatureFlag createFeatureFlag(@RequestBody FeatureFlag featureFlag) {
        return service.saveFeatureFlag(featureFlag);
    }
}