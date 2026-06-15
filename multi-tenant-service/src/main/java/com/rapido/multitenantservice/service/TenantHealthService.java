package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantHealthRequest;
import com.rapido.multitenantservice.entity.TenantHealth;
import com.rapido.multitenantservice.repository.TenantHealthRepository;
import org.springframework.stereotype.Service;

@Service
public class TenantHealthService {

    private final TenantHealthRepository repository;

    public TenantHealthService(
            TenantHealthRepository repository) {
        this.repository = repository;
    }

    public TenantHealth save(
            String tenantId,
            TenantHealthRequest request) {

        TenantHealth health =
                repository.findByTenantId(tenantId)
                        .orElse(new TenantHealth());

        health.setTenantId(tenantId);
        health.setDatabaseStatus(request.getDatabaseStatus());
        health.setApiStatus(request.getApiStatus());
        health.setNotificationStatus(request.getNotificationStatus());
        health.setBillingStatus(request.getBillingStatus());

        return repository.save(health);
    }

    public TenantHealth get(String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}