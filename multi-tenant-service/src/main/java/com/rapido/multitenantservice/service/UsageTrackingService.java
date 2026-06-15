package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.UsageTrackingRequest;
import com.rapido.multitenantservice.entity.UsageTracking;
import com.rapido.multitenantservice.repository.UsageTrackingRepository;
import org.springframework.stereotype.Service;

@Service
public class UsageTrackingService {

    private final UsageTrackingRepository repository;

    public UsageTrackingService(
            UsageTrackingRepository repository) {
        this.repository = repository;
    }

    public UsageTracking save(
            String tenantId,
            UsageTrackingRequest request) {

        UsageTracking usage =
                repository.findByTenantId(tenantId)
                        .orElse(new UsageTracking());

        usage.setTenantId(tenantId);
        usage.setApiCalls(request.getApiCalls());
        usage.setRides(request.getRides());
        usage.setDrivers(request.getDrivers());
        usage.setStorageUsageMb(
                request.getStorageUsageMb());

        return repository.save(usage);
    }

    public UsageTracking get(
            String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}