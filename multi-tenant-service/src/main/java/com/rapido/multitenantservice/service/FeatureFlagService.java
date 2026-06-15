package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.FeatureFlagRequest;
import com.rapido.multitenantservice.entity.FeatureFlag;
import com.rapido.multitenantservice.repository.FeatureFlagRepository;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {

    private final FeatureFlagRepository repository;

    public FeatureFlagService(
            FeatureFlagRepository repository) {
        this.repository = repository;
    }

    public FeatureFlag save(
            String tenantId,
            FeatureFlagRequest request) {

        FeatureFlag featureFlag =
                repository.findByTenantId(tenantId)
                        .orElse(new FeatureFlag());

        featureFlag.setTenantId(tenantId);
        featureFlag.setChatEnabled(
                request.getChatEnabled());
        featureFlag.setMlForecastEnabled(
                request.getMlForecastEnabled());
        featureFlag.setWalletEnabled(
                request.getWalletEnabled());
        featureFlag.setFraudDetectionEnabled(
                request.getFraudDetectionEnabled());

        return repository.save(featureFlag);
    }

    public FeatureFlag get(String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}