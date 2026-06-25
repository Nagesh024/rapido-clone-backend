package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.entity.AuditLog;
import com.rapido.platformengineering.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(AuditLogService service) {
        this.service = service;
    }

    @PostMapping
    public AuditLog createLog(
            @RequestBody AuditLog auditLog) {

        return service.save(auditLog);
    }

    @GetMapping
    public List<AuditLog> getLogs() {

        return service.findAll();
    }
}