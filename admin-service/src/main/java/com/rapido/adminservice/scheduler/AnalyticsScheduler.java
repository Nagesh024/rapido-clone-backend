package com.rapido.adminservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsScheduler {

    @Scheduled(fixedRate = 60000)
    public void generateAnalyticsSnapshot() {

        System.out.println(
                "Analytics Snapshot Generated Successfully"
        );
    }

    @Scheduled(fixedRate = 120000)
    public void generateRevenueSnapshot() {

        System.out.println(
                "Revenue Snapshot Generated Successfully"
        );
    }
}