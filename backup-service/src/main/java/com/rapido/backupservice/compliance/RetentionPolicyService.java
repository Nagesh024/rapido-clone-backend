package com.rapido.backupservice.compliance;

import org.springframework.stereotype.Service;

@Service
public class RetentionPolicyService {

    public String retentionPolicy() {

        return """
                Daily Backups -> 30 Days
                Monthly Backups -> 7 Years
                """;
    }
}