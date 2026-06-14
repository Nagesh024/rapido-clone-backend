package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository
        extends JpaRepository<AuditEvent, Long> {
}