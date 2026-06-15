package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantConfigurationRepository
        extends JpaRepository<TenantConfiguration, Long> {

    Optional<TenantConfiguration> findByTenantId(String tenantId);
}