package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantAlertRequest;
import com.rapido.multitenantservice.entity.TenantAlert;
import com.rapido.multitenantservice.repository.TenantAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantAlertService {

    private final TenantAlertRepository repository;

    public TenantAlertService(
            TenantAlertRepository repository) {
        this.repository = repository;
    }

    public TenantAlert create(
            String tenantId,
            TenantAlertRequest request) {

        TenantAlert alert = new TenantAlert();

        alert.setTenantId(tenantId);
        alert.setAlertType(request.getAlertType());
        alert.setAlertMessage(request.getAlertMessage());
        alert.setSeverity(request.getSeverity());
        alert.setStatus("OPEN");

        return repository.save(alert);
    }

    public List<TenantAlert> getAll(
            String tenantId) {

        return repository.findByTenantId(tenantId);
    }
}