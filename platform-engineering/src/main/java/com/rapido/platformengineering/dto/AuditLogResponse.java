package com.rapido.platformengineering.dto;

import java.time.LocalDateTime;

public record AuditLogResponse(

        Long id,
        String action,
        String userName,
        String status,
        LocalDateTime timestamp

) {
}