package com.rapido.platformengineering.dto;

public record MonitoringDashboardResponse(

        double cpuUsage,
        double memoryUsage,
        double latency,
        long errors,
        long deployments

) {
}