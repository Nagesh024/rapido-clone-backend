package com.rapido.platformservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapido.platformservice.entity.TenantConfiguration;
import com.rapido.platformservice.repository.TenantConfigurationRepository;

@Service
public class TenantConfigurationService {

    private final TenantConfigurationRepository repository;

    public TenantConfigurationService(TenantConfigurationRepository repository) {
        this.repository = repository;
    }

    public List<TenantConfiguration> getAllTenantConfigurations() {
        return repository.findAll();
    }

    public TenantConfiguration saveTenantConfiguration(TenantConfiguration tenantConfiguration) {
        return repository.save(tenantConfiguration);
    }
}