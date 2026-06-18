package com.rapido.platformengineering.dto;

public record DashboardSummaryDTO(
        int services,
        int environments,
        int deployments,
        int alerts
) {
}