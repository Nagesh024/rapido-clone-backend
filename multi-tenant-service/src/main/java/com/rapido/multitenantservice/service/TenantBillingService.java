package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantBillingRequest;
import com.rapido.multitenantservice.entity.TenantBilling;
import com.rapido.multitenantservice.repository.TenantBillingRepository;
import org.springframework.stereotype.Service;

@Service
public class TenantBillingService {

    private final TenantBillingRepository repository;

    public TenantBillingService(
            TenantBillingRepository repository) {
        this.repository = repository;
    }

    public TenantBilling save(
            String tenantId,
            TenantBillingRequest request) {

        TenantBilling billing =
                repository.findByTenantId(tenantId)
                        .orElse(new TenantBilling());

        billing.setTenantId(tenantId);
        billing.setPlan(request.getPlan());
        billing.setMonthlyCharge(
                request.getMonthlyCharge());

        return repository.save(billing);
    }

    public TenantBilling get(
            String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}