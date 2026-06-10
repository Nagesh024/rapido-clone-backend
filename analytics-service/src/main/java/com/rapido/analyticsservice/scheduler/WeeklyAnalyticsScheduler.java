package com.rapido.analyticsservice.scheduler;

import com.rapido.analyticsservice.dto.WeeklyAnalyticsResponse;
import com.rapido.analyticsservice.service.WeeklyAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeeklyAnalyticsScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(
                    WeeklyAnalyticsScheduler.class);

    private final WeeklyAnalyticsService
            weeklyAnalyticsService;

    public WeeklyAnalyticsScheduler(
            WeeklyAnalyticsService weeklyAnalyticsService) {

        this.weeklyAnalyticsService =
                weeklyAnalyticsService;
    }
    @Scheduled(cron = "0 0 0 * * MON")
    public void generateWeeklyReport() {

        WeeklyAnalyticsResponse report =
                weeklyAnalyticsService
                        .generateWeeklyAnalytics();

        log.info(
                "WEEKLY REPORT -> Revenue: {}, Rides: {}",
                report.getWeeklyRevenue(),
                report.getWeeklyRideCount());
    }
}