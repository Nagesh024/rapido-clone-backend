package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantConfigurationRequest;
import com.rapido.multitenantservice.entity.TenantConfiguration;
import com.rapido.multitenantservice.repository.TenantConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
public class TenantConfigurationService {

    private final TenantConfigurationRepository repository;

    public TenantConfigurationService(
            TenantConfigurationRepository repository) {
        this.repository = repository;
    }

    public TenantConfiguration save(
            String tenantId,
            TenantConfigurationRequest request) {

        TenantConfiguration config =
                repository.findByTenantId(tenantId)
                        .orElse(new TenantConfiguration());

        config.setTenantId(tenantId);
        config.setPricingRule(request.getPricingRule());
        config.setCommissionRule(request.getCommissionRule());
        config.setRideCategory(request.getRideCategory());
        config.setNotificationTemplate(
                request.getNotificationTemplate());

        return repository.save(config);
    }

    public TenantConfiguration get(String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}