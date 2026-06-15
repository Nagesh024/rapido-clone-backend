package com.rapido.globalservice.featureflag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureFlagRepository
        extends JpaRepository<FeatureFlag, Long> {

    Optional<FeatureFlag>
    findByTenantIdAndCountryCodeAndRegionCodeAndFeatureName(
            String tenantId,
            String countryCode,
            String regionCode,
            String featureName
    );
}