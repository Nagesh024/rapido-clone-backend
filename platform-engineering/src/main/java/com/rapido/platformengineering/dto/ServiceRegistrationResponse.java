package com.rapido.platformengineering.dto;

public record ServiceRegistrationResponse(
        Long id,
        String serviceName,
        String owner,
        String repositoryUrl,
        String environment,
        String sla
) {
}