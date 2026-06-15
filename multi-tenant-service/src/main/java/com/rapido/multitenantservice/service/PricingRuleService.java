package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.PricingRuleRequest;
import com.rapido.multitenantservice.entity.PricingRule;
import com.rapido.multitenantservice.repository.PricingRuleRepository;
import org.springframework.stereotype.Service;

@Service
public class PricingRuleService {

    private final PricingRuleRepository repository;

    public PricingRuleService(
            PricingRuleRepository repository) {
        this.repository = repository;
    }

    public PricingRule save(
            String tenantId,
            PricingRuleRequest request) {

        PricingRule rule =
                repository.findByTenantId(tenantId)
                        .orElse(new PricingRule());

        rule.setTenantId(tenantId);
        rule.setBaseFare(request.getBaseFare());
        rule.setSurgeMultiplier(
                request.getSurgeMultiplier());
        rule.setCommissionPercentage(
                request.getCommissionPercentage());

        return repository.save(rule);
    }

    public PricingRule get(String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}