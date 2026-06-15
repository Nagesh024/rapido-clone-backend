package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantAuditRequest;
import com.rapido.multitenantservice.entity.TenantAudit;
import com.rapido.multitenantservice.repository.TenantAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TenantAuditService {

    private final TenantAuditRepository repository;

    public TenantAuditService(
            TenantAuditRepository repository) {
        this.repository = repository;
    }

    public TenantAudit save(
            String tenantId,
            TenantAuditRequest request) {

        TenantAudit audit = new TenantAudit();

        audit.setTenantId(tenantId);
        audit.setActionType(
                request.getActionType());
        audit.setActionDetails(
                request.getActionDetails());
        audit.setPerformedBy(
                request.getPerformedBy());
        audit.setCreatedAt(
                LocalDateTime.now());

        return repository.save(audit);
    }

    public List<TenantAudit> getAll(
            String tenantId) {

        return repository.findByTenantId(
                tenantId);
    }
}