package com.rapido.analyticsservice.scheduler;

import com.rapido.analyticsservice.dto.KPIDashboardResponse;
import com.rapido.analyticsservice.service.KPIAggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyKPIScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(
                    DailyKPIScheduler.class);

    private final KPIAggregationService
            kpiAggregationService;

    public DailyKPIScheduler(
            KPIAggregationService
                    kpiAggregationService) {

        this.kpiAggregationService =
                kpiAggregationService;
    }
    
    @Scheduled(cron = "0 0 0 * * *")
    public void generateDailyKPIs() {

        KPIDashboardResponse kpi =
                kpiAggregationService
                        .getKPIs();

        log.info(
                "DAILY KPI REPORT -> Total Rides: {}, Revenue: {}",
                kpi.getTotalRides(),
                kpi.getTotalRevenue());
    }
}