package com.rapido.platformengineering.technologylifecycle.repository;

import com.rapido.platformengineering.technologylifecycle.entity.TechnologyCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyCatalogRepository
        extends JpaRepository<TechnologyCatalog, Long> {
}