package com.rapido.backupservice.compliance;

import org.springframework.stereotype.Service;

@Service
public class CountryRetentionService {

    public String countryRules() {

        return """
                India -> 7 Years
                USA -> 7 Years
                EU -> GDPR Retention Policy
                """;
    }
}