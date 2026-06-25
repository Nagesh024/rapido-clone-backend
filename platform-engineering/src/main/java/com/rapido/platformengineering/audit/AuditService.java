package com.rapido.platformengineering.audit;

import com.rapido.platformengineering.entity.AuditEvent;
import com.rapido.platformengineering.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditEventRepository repository;

    public AuditService(AuditEventRepository repository) {
        this.repository = repository;
    }

    public void save(
            String type,
            String actor,
            String action
    ) {

        AuditEvent event = new AuditEvent();

        event.setEventType1(type);
        event.setActor(actor);
        event.setActor(action);
        event.setCreatedAt(LocalDateTime.now());

        repository.save(event);
    }
}