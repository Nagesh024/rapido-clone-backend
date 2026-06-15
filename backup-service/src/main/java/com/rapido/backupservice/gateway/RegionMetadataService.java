package com.rapido.backupservice.gateway;

import org.springframework.stereotype.Service;

@Service
public class RegionMetadataService {

    public String getActiveRegion() {

        String region =
                System.getenv("ACTIVE_REGION");

        if (region == null || region.isBlank()) {
            return "region-a";
        }

        return region;
    }
}