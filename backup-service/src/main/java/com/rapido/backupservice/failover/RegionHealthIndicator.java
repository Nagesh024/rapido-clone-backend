package com.rapido.backupservice.failover;

import org.springframework.stereotype.Component;

@Component
public class RegionHealthIndicator {

    public boolean isPrimaryRegionHealthy() {

        System.out.println(
                "Checking Region A Health");

        return false;
    }
}