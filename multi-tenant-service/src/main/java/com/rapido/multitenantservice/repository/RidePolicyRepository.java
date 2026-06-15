package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.RidePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RidePolicyRepository
        extends JpaRepository<RidePolicy, Long> {

    List<RidePolicy> findByTenantId(String tenantId);

    Optional<RidePolicy> findByTenantIdAndRideType(
            String tenantId,
            String rideType);
}