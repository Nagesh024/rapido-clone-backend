package com.rapido.platformengineering.dto;

public record EnvironmentResponse(

        Long id,
        String environmentName,
        String owner,
        String cpuUsage,
        String memoryUsage,
        String deploymentStatus

) {
}