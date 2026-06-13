package com.rapido.globalservice.compliance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplianceConfigurationRepository
        extends JpaRepository<ComplianceConfiguration, Long> {

    Optional<ComplianceConfiguration>
    findByCountryCode(String countryCode);
}