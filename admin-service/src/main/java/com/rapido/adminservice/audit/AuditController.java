package com.rapido.adminservice.audit;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/audit")
public class AuditController {

    private final AuditLogRepository auditLogRepository;

    public AuditController(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Audit Controller Working";
    }

    @GetMapping("/logs")
    public List<AuditLog> getLogs() {
        return auditLogRepository.findAll();
    }
}