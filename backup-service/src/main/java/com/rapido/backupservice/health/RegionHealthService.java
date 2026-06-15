package com.rapido.backupservice.health;

import org.springframework.stereotype.Service;

@Service
public class RegionHealthService {

    public boolean isRegionHealthy(String region) {

        return !"FAILED".equalsIgnoreCase(
                System.getenv(region + "_STATUS"));
    }
}