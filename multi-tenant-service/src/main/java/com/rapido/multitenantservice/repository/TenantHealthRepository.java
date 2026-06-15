package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantHealth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantHealthRepository
        extends JpaRepository<TenantHealth, Long> {

    Optional<TenantHealth> findByTenantId(String tenantId);
}