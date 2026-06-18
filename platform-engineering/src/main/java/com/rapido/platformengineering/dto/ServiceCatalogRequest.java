package com.rapido.platformengineering.dto;

public record ServiceCatalogRequest(
        String serviceName,
        String owner,
        String repositoryUrl,
        String environment,
        String sla
) {
}