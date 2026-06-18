package com.rapido.platformengineering.dto;

public record DeploymentStatusResponse(

        String applicationName,
        String status,
        String environment

) {
}