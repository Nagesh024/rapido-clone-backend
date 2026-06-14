package com.rapido.search.repository;

import com.rapido.search.model.SearchAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchAuditRepository
        extends JpaRepository<SearchAudit, Long> {
}