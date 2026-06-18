package com.rapido.platformengineering.dto;

public record CostMetricResponse(

        Double environmentCost,
        Double serviceCost,
        Double clusterCost,
        Double databaseCost,
        Double teamCost

) {
}