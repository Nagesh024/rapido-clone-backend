package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantSLA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantSLARepository
        extends JpaRepository<TenantSLA, Long> {

    List<TenantSLA> findByTenantId(String tenantId);
}