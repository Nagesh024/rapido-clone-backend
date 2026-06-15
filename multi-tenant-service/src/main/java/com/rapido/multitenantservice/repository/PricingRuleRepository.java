package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PricingRuleRepository
        extends JpaRepository<PricingRule, Long> {

    Optional<PricingRule> findByTenantId(String tenantId);
}