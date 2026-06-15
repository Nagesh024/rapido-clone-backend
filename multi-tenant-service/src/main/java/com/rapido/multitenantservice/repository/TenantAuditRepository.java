package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantAuditRepository
        extends JpaRepository<TenantAudit, Long> {

    List<TenantAudit> findByTenantId(
            String tenantId);
}