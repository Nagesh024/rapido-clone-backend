package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantCompliance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantComplianceRepository
        extends JpaRepository<TenantCompliance, Long> {

    List<TenantCompliance> findByTenantId(String tenantId);
}