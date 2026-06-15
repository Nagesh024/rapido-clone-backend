package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.UsageTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsageTrackingRepository
        extends JpaRepository<UsageTracking, Long> {

    Optional<UsageTracking> findByTenantId(
            String tenantId);
}