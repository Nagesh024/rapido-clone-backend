package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantAuditRequest;
import com.rapido.multitenantservice.entity.TenantAudit;
import com.rapido.multitenantservice.service.TenantAuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/audit")
public class TenantAuditController {

    private final TenantAuditService service;

    public TenantAuditController(
            TenantAuditService service) {
        this.service = service;
    }

    @PostMapping
    public TenantAudit createAudit(
            @RequestBody TenantAuditRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<TenantAudit> getAuditLogs() {

        return service.getAll(
                TenantContext.getTenantId());
    }
}