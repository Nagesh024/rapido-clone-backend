package com.rapido.platformengineering.dto;

public record LoadTestResponse(

        String developers,
        String deployments,
        String environments,
        String stability,
        String throughput,
        String reliability

) {
}