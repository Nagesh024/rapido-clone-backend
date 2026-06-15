package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantBilling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantBillingRepository
        extends JpaRepository<TenantBilling, Long> {

    Optional<TenantBilling> findByTenantId(
            String tenantId);
}