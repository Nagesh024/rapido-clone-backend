package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.AuditLogResponse;
import com.rapido.platformengineering.entity.AuditLog;
import com.rapido.platformengineering.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(
            AuditLogRepository repository) {

        this.repository = repository;
    }

    public List<AuditLogResponse> getLogs() {

        return repository.findAll()
                .stream()
                .map(log ->
                        new AuditLogResponse(
                                log.getId(),
                                log.getAction(),
                                log.getUserName(),
                                log.getStatus(),
                                log.getTimestamp()
                        ))
                .toList();
    }

    public List<AuditLog> findAll() {

        return repository.findAll();
    }

    public AuditLog save(AuditLog auditLog) {

        if (auditLog.getTimestamp() == null) {
            auditLog.setTimestamp(LocalDateTime.now());
        }

        return repository.save(auditLog);
    }
}