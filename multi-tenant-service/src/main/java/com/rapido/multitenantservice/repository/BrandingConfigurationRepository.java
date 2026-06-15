package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.BrandingConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandingConfigurationRepository
        extends JpaRepository<BrandingConfiguration, Long> {

    Optional<BrandingConfiguration> findByTenantId(String tenantId);
}