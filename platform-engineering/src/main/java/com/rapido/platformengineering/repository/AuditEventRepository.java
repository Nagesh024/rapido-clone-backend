package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditEventRepository
        extends JpaRepository<AuditEvent, Long> {
}