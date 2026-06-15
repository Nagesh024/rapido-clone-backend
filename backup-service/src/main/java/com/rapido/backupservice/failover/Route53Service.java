package com.rapido.backupservice.failover;

import org.springframework.stereotype.Service;

@Service
public class Route53Service {

    public void switchTrafficToSecondary() {

        System.out.println(
                "Route53 Updated");

        System.out.println(
                "Traffic Redirected To Region B");
    }
}