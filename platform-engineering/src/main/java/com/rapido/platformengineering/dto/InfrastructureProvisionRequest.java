package com.rapido.platformengineering.dto;

public record InfrastructureProvisionRequest(
        String environment,
        String service
) {
}