package com.rapido.backupservice.gateway;

import com.rapido.backupservice.health.RegionHealthService;
import org.springframework.stereotype.Component;

@Component
public class RegionRoutingFilter {

    private final RegionMetadataService metadataService;
    private final RegionHealthService healthService;

    public RegionRoutingFilter(
            RegionMetadataService metadataService,
            RegionHealthService healthService) {

        this.metadataService = metadataService;
        this.healthService = healthService;
    }

    public String determineRegion() {

        String activeRegion =
                metadataService.getActiveRegion();

        if (healthService.isRegionHealthy(activeRegion)) {

            return activeRegion;
        }

        return "region-b";
    }
}