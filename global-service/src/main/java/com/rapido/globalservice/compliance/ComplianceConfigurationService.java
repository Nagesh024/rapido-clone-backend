package com.rapido.globalservice.compliance;

import org.springframework.stereotype.Service;

@Service
public class ComplianceConfigurationService {

    private final ComplianceConfigurationRepository repository;

    public ComplianceConfigurationService(
            ComplianceConfigurationRepository repository
    ) {
        this.repository = repository;
    }

    public ComplianceConfiguration getConfiguration(
            String countryCode
    ) {

        return repository
                .findByCountryCode(countryCode)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Compliance configuration not found"
                        ));
    }
}