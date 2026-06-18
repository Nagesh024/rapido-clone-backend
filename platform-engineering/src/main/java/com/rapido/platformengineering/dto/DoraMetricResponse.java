package com.rapido.platformengineering.dto;

public record DoraMetricResponse(

        Integer deploymentsPerDay,
        Double leadTimeHours,
        Double mttrHours,
        Double changeFailureRate

) {
}