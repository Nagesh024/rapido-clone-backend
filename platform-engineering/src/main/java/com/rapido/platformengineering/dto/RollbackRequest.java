package com.rapido.platformengineering.dto;

public record RollbackRequest(

        String applicationName,
        String revision

) {
}