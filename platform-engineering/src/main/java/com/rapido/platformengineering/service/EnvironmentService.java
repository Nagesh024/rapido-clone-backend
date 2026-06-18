package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.EnvironmentRequest;
import com.rapido.platformengineering.dto.EnvironmentResponse;
import com.rapido.platformengineering.entity.EnvironmentInfo;
import com.rapido.platformengineering.repository.EnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    private final EnvironmentRepository repository;

    public EnvironmentService(
            EnvironmentRepository repository) {

        this.repository = repository;
    }

    public EnvironmentResponse create(
            EnvironmentRequest request) {

        EnvironmentInfo env =
                new EnvironmentInfo();

        env.setEnvironmentName(
                request.environmentName());

        env.setOwner(
                request.owner());

        env.setCpuUsage(
                request.cpuUsage());

        env.setMemoryUsage(
                request.memoryUsage());

        env.setDeploymentStatus(
                request.deploymentStatus());

        EnvironmentInfo saved =
                repository.save(env);

        return map(saved);
    }

    public List<EnvironmentResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private EnvironmentResponse map(
            EnvironmentInfo env) {

        return new EnvironmentResponse(
                env.getId(),
                env.getEnvironmentName(),
                env.getOwner(),
                env.getCpuUsage(),
                env.getMemoryUsage(),
                env.getDeploymentStatus()
        );
    }
}