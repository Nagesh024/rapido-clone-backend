package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditEventRepository
        extends JpaRepository<AuditEvent, Long> {

    List<AuditEvent> findByEventType(
            String eventType);

    Long countByEventType(
            String eventType);

    @Query("""
           SELECT COUNT(a)
           FROM AuditEvent a
           WHERE a.createdAt >= :date
           """)
    Long countEventsAfter(
            @Param("date")
            LocalDateTime date);
}