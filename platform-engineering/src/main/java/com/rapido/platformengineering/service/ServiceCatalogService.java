package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.ServiceCatalogRequest;
import com.rapido.platformengineering.dto.ServiceCatalogResponse;
import com.rapido.platformengineering.entity.ServiceCatalog;
import com.rapido.platformengineering.repository.ServiceCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCatalogService {

    private final ServiceCatalogRepository repository;

    public ServiceCatalogService(ServiceCatalogRepository repository) {
        this.repository = repository;
    }

    public ServiceCatalogResponse register(ServiceCatalogRequest request) {

        ServiceCatalog service = new ServiceCatalog();

        service.setServiceName(request.serviceName());
        service.setOwner(request.owner());
        service.setRepositoryUrl(request.repositoryUrl());
        service.setEnvironment(request.environment());
        service.setSla(request.sla());

        ServiceCatalog saved = repository.save(service);

        return new ServiceCatalogResponse(
                saved.getId(),
                saved.getServiceName(),
                saved.getOwner(),
                saved.getRepositoryUrl(),
                saved.getEnvironment(),
                saved.getSla()
        );
    }

    public List<ServiceCatalogResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(service ->
                        new ServiceCatalogResponse(
                                service.getId(),
                                service.getServiceName(),
                                service.getOwner(),
                                service.getRepositoryUrl(),
                                service.getEnvironment(),
                                service.getSla()
                        ))
                .toList();
    }
}