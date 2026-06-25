package com.rapido.platformengineering.technologylifecycle.service;

import com.rapido.platformengineering.technologylifecycle.entity.TechnologyCatalog;
import com.rapido.platformengineering.technologylifecycle.repository.TechnologyCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyCatalogService {

    private final TechnologyCatalogRepository repository;

    public TechnologyCatalogService(
            TechnologyCatalogRepository repository) {
        this.repository = repository;
    }

    public TechnologyCatalog save(
            TechnologyCatalog technology) {
        return repository.save(technology);
    }

    public List<TechnologyCatalog> findAll() {
        return repository.findAll();
    }
}