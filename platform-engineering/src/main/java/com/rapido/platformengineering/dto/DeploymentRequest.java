package com.rapido.platformengineering.dto;

public record DeploymentRequest(

        String applicationName,
        String environment,
        String imageTag

) {
}