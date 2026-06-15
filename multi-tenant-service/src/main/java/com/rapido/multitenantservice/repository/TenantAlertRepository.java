package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantAlertRepository
        extends JpaRepository<TenantAlert, Long> {

    List<TenantAlert> findByTenantId(String tenantId);
}