package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantSLARequest;
import com.rapido.multitenantservice.entity.TenantSLA;
import com.rapido.multitenantservice.repository.TenantSLARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantSLAService {

    private final TenantSLARepository repository;

    public TenantSLAService(
            TenantSLARepository repository) {
        this.repository = repository;
    }

    public TenantSLA save(
            String tenantId,
            TenantSLARequest request) {

        TenantSLA sla = new TenantSLA();

        sla.setTenantId(tenantId);
        sla.setSlaType(request.getSlaType());
        sla.setTargetValue(request.getTargetValue());
        sla.setStatus(request.getStatus());

        return repository.save(sla);
    }

    public List<TenantSLA> getAll(
            String tenantId) {

        return repository.findByTenantId(
                tenantId);
    }
}