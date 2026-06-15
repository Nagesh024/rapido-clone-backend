package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.entity.TenantBilling;
import com.rapido.multitenantservice.repository.TenantBillingRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionBillingEngine {

    private final TenantBillingRepository repository;

    public SubscriptionBillingEngine(
            TenantBillingRepository repository) {
        this.repository = repository;
    }

    public TenantBilling generateBill(
            String tenantId) {

        TenantBilling billing =
                repository.findByTenantId(tenantId)
                        .orElseThrow();

        double usageCharge = 500.0;
        double featureCharge = 1000.0;

        double total =
                billing.getMonthlyCharge()
                        + usageCharge
                        + featureCharge;

        billing.setUsageCharge(usageCharge);
        billing.setFeatureCharge(featureCharge);
        billing.setTotalCharge(total);

        return repository.save(billing);
    }
}