package com.rapido.globalservice.featureflag;

import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {

    private final FeatureFlagRepository repository;

    public FeatureFlagService(
            FeatureFlagRepository repository
    ) {
        this.repository = repository;
    }

    public FeatureFlagResponse checkFeature(
            String tenantId,
            String countryCode,
            String regionCode,
            String featureName
    ) {

        FeatureFlag flag =
                repository
                        .findByTenantIdAndCountryCodeAndRegionCodeAndFeatureName(
                                tenantId,
                                countryCode,
                                regionCode,
                                featureName
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Feature flag not found"
                                ));

        FeatureFlagResponse response =
                new FeatureFlagResponse();

        response.setTenantId(tenantId);
        response.setCountryCode(countryCode);
        response.setRegionCode(regionCode);
        response.setFeatureName(featureName);
        response.setEnabled(flag.getEnabled());

        return response;
    }
}