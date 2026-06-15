package com.rapido.backupservice.dashboard;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardMetrics getMetrics() {

        return new DashboardMetrics(
                "HEALTHY",
                "2 Seconds",
                "SUCCESS",
                "4 Minutes",
                "NONE");
    }
}