package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.ServiceRegistrationRequest;
import com.rapido.platformengineering.dto.ServiceRegistrationResponse;
import com.rapido.platformengineering.entity.PlatformServiceEntity;
import com.rapido.platformengineering.repository.PlatformServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRegistrationService {

    private final PlatformServiceRepository repository;

    public ServiceRegistrationService(
            PlatformServiceRepository repository) {
        this.repository = repository;
    }

    public ServiceRegistrationResponse register(
            ServiceRegistrationRequest request) {

        PlatformServiceEntity entity =
                new PlatformServiceEntity();

        entity.setServiceName(request.serviceName());
        entity.setOwner(request.owner());
        entity.setRepositoryUrl(request.repositoryUrl());
        entity.setEnvironment(request.environment());
        entity.setSla(request.sla());

        PlatformServiceEntity saved =
                repository.save(entity);

        return map(saved);
    }

    public List<ServiceRegistrationResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public ServiceRegistrationResponse findById(Long id) {

        PlatformServiceEntity service =
                repository.findById(id)
                        .orElseThrow();

        return map(service);
    }

    private ServiceRegistrationResponse map(
            PlatformServiceEntity entity) {

        return new ServiceRegistrationResponse(
                entity.getId(),
                entity.getServiceName(),
                entity.getOwner(),
                entity.getRepositoryUrl(),
                entity.getEnvironment(),
                entity.getSla()
        );
    }
}