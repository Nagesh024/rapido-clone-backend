package com.rapido.backupservice.monitoring;

import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    public String healthStatus() {

        return """
                Region A : HEALTHY
                Region B : HEALTHY
                Backup Service : HEALTHY
                Database : HEALTHY
                """;
    }
}