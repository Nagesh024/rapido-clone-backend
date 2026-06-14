package com.rapido.adminservice.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuditService {

    private static final Logger logger =
            LoggerFactory.getLogger(AuditService.class);

    private final AuditLogRepository auditLogRepository;

    public AuditService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void log(String adminEmail, String action, String description) {

        AuditLog audit = new AuditLog();

        audit.setAdminEmail(adminEmail);
        audit.setAction(action);
        audit.setDescription(description);
        audit.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(audit);

        logger.info("Audit event recorded: {} - {}", action, description);
    }
}