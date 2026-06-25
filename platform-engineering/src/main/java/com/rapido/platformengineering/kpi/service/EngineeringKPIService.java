package com.rapido.platformengineering.kpi.service;

import com.rapido.platformengineering.kpi.entity.EngineeringKPI;
import com.rapido.platformengineering.kpi.repository.EngineeringKPIRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineeringKPIService {

    private final EngineeringKPIRepository repository;

    public EngineeringKPIService(
            EngineeringKPIRepository repository) {

        this.repository = repository;
    }

    public EngineeringKPI save(
            EngineeringKPI kpi) {

        return repository.save(kpi);
    }

    public List<EngineeringKPI> findAll() {

        return repository.findAll();
    }
}