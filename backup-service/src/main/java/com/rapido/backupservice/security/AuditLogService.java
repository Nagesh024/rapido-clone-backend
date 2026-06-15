package com.rapido.backupservice.security;

import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    public String createAuditLog() {

        System.out.println(
                "Audit Log Generated");

        return "Audit Log Created";
    }
}