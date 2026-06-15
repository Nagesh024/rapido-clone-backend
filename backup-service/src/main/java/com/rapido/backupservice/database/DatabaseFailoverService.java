package com.rapido.backupservice.database;

import org.springframework.stereotype.Service;

@Service
public class DatabaseFailoverService {

    private final DatabaseHealthService healthService;
    private final FailoverDataSourceConfig config;

    public DatabaseFailoverService(
            DatabaseHealthService healthService,
            FailoverDataSourceConfig config) {

        this.healthService = healthService;
        this.config = config;
    }

    public String switchDatabase() {

        if (!healthService.isPrimaryHealthy()) {

            System.out.println(
                    "Primary Database Down");

            System.out.println(
                    "Switching To Secondary Database");

            return config.getSecondaryUrl();
        }

        return config.getPrimaryUrl();
    }
}