package com.rapido.platformengineering.dto;

public record EnvironmentRequest(

        String environmentName,
        String owner,
        String cpuUsage,
        String memoryUsage,
        String deploymentStatus

) {
}