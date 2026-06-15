package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.BrandingRequest;
import com.rapido.multitenantservice.entity.BrandingConfiguration;
import com.rapido.multitenantservice.repository.BrandingConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandingConfigurationService {

    private final BrandingConfigurationRepository repository;

    public BrandingConfigurationService(
            BrandingConfigurationRepository repository) {
        this.repository = repository;
    }

    public BrandingConfiguration save(
            String tenantId,
            BrandingRequest request) {

        BrandingConfiguration branding =
                repository.findByTenantId(tenantId)
                        .orElse(new BrandingConfiguration());

        branding.setTenantId(tenantId);
        branding.setLogoUrl(request.getLogoUrl());
        branding.setPrimaryColor(request.getPrimaryColor());
        branding.setCompanyName(request.getCompanyName());

        return repository.save(branding);
    }

    public BrandingConfiguration update(
            String tenantId,
            BrandingRequest request) {

        BrandingConfiguration branding =
                repository.findByTenantId(tenantId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Branding not found"));

        branding.setLogoUrl(request.getLogoUrl());
        branding.setPrimaryColor(request.getPrimaryColor());
        branding.setCompanyName(request.getCompanyName());

        return repository.save(branding);
    }

    public BrandingConfiguration get(
            String tenantId) {

        return repository.findByTenantId(tenantId)
                .orElse(null);
    }
}