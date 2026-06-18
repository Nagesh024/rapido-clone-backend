package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.AuditLogResponse;
import com.rapido.platformengineering.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(
            AuditLogService service) {

        this.service = service;
    }

    @GetMapping
    public List<AuditLogResponse> getLogs() {

        return service.getLogs();
    }
}