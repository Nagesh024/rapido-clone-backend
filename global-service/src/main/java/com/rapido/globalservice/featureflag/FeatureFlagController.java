package com.rapido.globalservice.featureflag;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feature-flags")
public class FeatureFlagController {

    private final FeatureFlagService service;

    public FeatureFlagController(
            FeatureFlagService service
    ) {
        this.service = service;
    }

    @GetMapping("/check")
    public FeatureFlagResponse check(
            @RequestParam String tenantId,
            @RequestParam String countryCode,
            @RequestParam String regionCode,
            @RequestParam String featureName
    ) {

        return service.checkFeature(
                tenantId,
                countryCode,
                regionCode,
                featureName
        );
    }
}