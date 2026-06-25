package com.rapido.platformengineering.dependencygovernance.service;

import com.rapido.platformengineering.dependencygovernance.entity.DependencyInventory;
import com.rapido.platformengineering.dependencygovernance.repository.DependencyInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependencyInventoryService {

    private final DependencyInventoryRepository repository;

    public DependencyInventoryService(
            DependencyInventoryRepository repository) {
        this.repository = repository;
    }

    public DependencyInventory save(
            DependencyInventory dependency) {
        return repository.save(dependency);
    }

    public List<DependencyInventory> findAll() {
        return repository.findAll();
    }
}