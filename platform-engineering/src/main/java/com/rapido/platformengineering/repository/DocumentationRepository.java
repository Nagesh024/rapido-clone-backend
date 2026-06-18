package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentationRepository
        extends JpaRepository<Documentation, Long> {

    List<Documentation> findByCategory(String category);
}