package com.rapido.platformengineering.dto;

public record InfrastructureProvisionResponse(
        Long id,
        String environment,
        String service,
        String status
) {
}