package com.rapido.platformengineering.standards.service;

import com.rapido.platformengineering.standards.entity.EngineeringStandard;
import com.rapido.platformengineering.standards.enums.StandardCategory;
import com.rapido.platformengineering.standards.repository.EngineeringStandardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineeringStandardService {

    private final EngineeringStandardRepository repository;

    public EngineeringStandardService(
            EngineeringStandardRepository repository) {
        this.repository = repository;
    }

    public EngineeringStandard save(
            EngineeringStandard standard) {
        return repository.save(standard);
    }

    public List<EngineeringStandard> getAll() {
        return repository.findAll();
    }

    public List<EngineeringStandard> getByCategory(
            StandardCategory category) {
        return repository.findByCategory(category);
    }
}