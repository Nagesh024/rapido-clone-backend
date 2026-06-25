package com.rapido.platformservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapido.platformservice.entity.FeatureFlag;
import com.rapido.platformservice.repository.FeatureFlagRepository;

@Service
public class FeatureFlagService {

    private final FeatureFlagRepository repository;

    public FeatureFlagService(FeatureFlagRepository repository) {
        this.repository = repository;
    }

    public List<FeatureFlag> getAllFeatureFlags() {
        return repository.findAll();
    }

    public FeatureFlag saveFeatureFlag(FeatureFlag featureFlag) {
        return repository.save(featureFlag);
    }
}