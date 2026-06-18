package com.rapido.platformengineering.dto;

public record ServiceRegistrationRequest(
        String serviceName,
        String owner,
        String repositoryUrl,
        String environment,
        String sla
) {
}