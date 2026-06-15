package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantComplianceRequest;
import com.rapido.multitenantservice.entity.TenantCompliance;
import com.rapido.multitenantservice.repository.TenantComplianceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantComplianceService {

    private final TenantComplianceRepository repository;

    public TenantComplianceService(
            TenantComplianceRepository repository) {
        this.repository = repository;
    }

    public TenantCompliance save(
            String tenantId,
            TenantComplianceRequest request) {

        TenantCompliance compliance =
                new TenantCompliance();

        compliance.setTenantId(tenantId);
        compliance.setComplianceType(
                request.getComplianceType());
        compliance.setComplianceStatus(
                request.getComplianceStatus());
        compliance.setRemarks(
                request.getRemarks());

        return repository.save(compliance);
    }

    public List<TenantCompliance> getAll(
            String tenantId) {

        return repository.findByTenantId(
                tenantId);
    }
}