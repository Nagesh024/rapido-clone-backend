package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository
        extends JpaRepository<Tenant, Long> {

    List<Tenant> findByTenantId(String tenantId);
}