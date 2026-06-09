package com.rapido.search.service;

import com.rapido.search.model.LocationDocument;
import com.rapido.search.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@Service
public class AutoCompleteService {

    private final LocationRepository repository;

    public AutoCompleteService(LocationRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "autocomplete", key = "#query")
    public List<LocationDocument> search(String query) {

        System.out.println("FETCHING FROM ELASTICSEARCH");

        return repository.findByNameContainingIgnoreCase(query);
    }
}