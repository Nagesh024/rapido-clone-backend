package com.rapido.backupservice.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FailoverDataSourceConfig {

    @Value("${db.primary.url}")
    private String primaryUrl;

    @Value("${db.secondary.url}")
    private String secondaryUrl;

    public String getPrimaryUrl() {
        return primaryUrl;
    }

    public String getSecondaryUrl() {
        return secondaryUrl;
    }
}