package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.InfrastructureProvisionRequest;
import com.rapido.platformengineering.dto.InfrastructureProvisionResponse;
import com.rapido.platformengineering.entity.InfrastructureProvision;
import com.rapido.platformengineering.repository.InfrastructureProvisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfrastructureService {

    private final InfrastructureProvisionRepository repository;

    public InfrastructureService(
            InfrastructureProvisionRepository repository) {
        this.repository = repository;
    }

    public InfrastructureProvisionResponse provision(
            InfrastructureProvisionRequest request) {

        InfrastructureProvision provision =
                new InfrastructureProvision();

        provision.setEnvironment(
                request.environment());

        provision.setServiceName(
                request.service());

        provision.setStatus(
                "PROVISIONED");

        InfrastructureProvision saved =
                repository.save(provision);

        return map(saved);
    }

    public List<InfrastructureProvisionResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private InfrastructureProvisionResponse map(
            InfrastructureProvision provision) {

        return new InfrastructureProvisionResponse(
                provision.getId(),
                provision.getEnvironment(),
                provision.getServiceName(),
                provision.getStatus()
        );
    }
}