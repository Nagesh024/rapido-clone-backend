package com.rapido.platformengineering.dto;

public record PortalModuleDTO(
        Long id,
        String moduleName,
        String description,
        String status
) {
}