package com.rapido.backupservice.failover;

import org.springframework.stereotype.Service;

@Service
public class FailoverService {

    private final RegionHealthIndicator healthIndicator;
    private final Route53Service route53Service;

    public FailoverService(
            RegionHealthIndicator healthIndicator,
            Route53Service route53Service) {

        this.healthIndicator = healthIndicator;
        this.route53Service = route53Service;
    }

    public String executeFailover() {

        if (!healthIndicator.isPrimaryRegionHealthy()) {

            System.out.println(
                    "Region A Failure Detected");

            route53Service.switchTrafficToSecondary();

            return "Failover Completed";
        }

        return "Primary Region Healthy";
    }
}