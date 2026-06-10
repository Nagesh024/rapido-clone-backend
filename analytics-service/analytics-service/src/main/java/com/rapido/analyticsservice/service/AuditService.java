package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.entity.AuditEvent;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditEventRepository auditEventRepository;

    public AuditService(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    public void saveEvent(String eventType, String payload) {

        AuditEvent event = new AuditEvent();

        event.setEventType(eventType);
        event.setPayload(payload);
        event.setCreatedAt(LocalDateTime.now());
        

        auditEventRepository.save(event);
    }
}