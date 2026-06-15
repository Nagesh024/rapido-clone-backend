package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.FeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureFlagRepository
        extends JpaRepository<FeatureFlag, Long> {

    Optional<FeatureFlag> findByTenantId(String tenantId);
}