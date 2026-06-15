package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.TenantNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantNotificationRepository
        extends JpaRepository<TenantNotification, Long> {

    List<TenantNotification> findByTenantId(String tenantId);
}