package com.rapido.platformengineering.dto;

public record PlatformResponse(
        String service,
        String status,
        String version
) {
}