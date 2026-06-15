package com.rapido.analyticsservice.scheduler;

import com.rapido.analyticsservice.dto.MonthlyAnalyticsResponse;
import com.rapido.analyticsservice.service.MonthlyAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonthlyAnalyticsScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(
                    MonthlyAnalyticsScheduler.class);

    private final MonthlyAnalyticsService
            monthlyAnalyticsService;

    public MonthlyAnalyticsScheduler(
            MonthlyAnalyticsService monthlyAnalyticsService) {

        this.monthlyAnalyticsService =
                monthlyAnalyticsService;
    }

    @Scheduled(fixedRate = 90000)
    public void generateMonthlyReport() {

        MonthlyAnalyticsResponse report =
                monthlyAnalyticsService
                        .generateMonthlyAnalytics();

        log.info(
                "MONTHLY REPORT -> Revenue: {}, Rides: {}",
                report.getMonthlyRevenue(),
                report.getMonthlyRideCount());
    }
}