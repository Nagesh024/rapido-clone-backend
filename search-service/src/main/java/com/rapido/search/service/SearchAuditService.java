package com.rapido.search.service;

import com.rapido.search.model.SearchAudit;
import com.rapido.search.repository.SearchAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchAuditService {

    private final SearchAuditRepository repository;

    public SearchAuditService(
            SearchAuditRepository repository) {
        this.repository = repository;
    }

    public void saveAudit(
            Long userId,
            String searchTerm) {

        SearchAudit audit =
                new SearchAudit();

        audit.setUserId(userId);
        audit.setSearchTerm(searchTerm);
        audit.setTimestamp(
                LocalDateTime.now()
        );

        repository.save(audit);
    }

    public List<SearchAudit> getAuditHistory() {
        return repository.findAll();
    }
}