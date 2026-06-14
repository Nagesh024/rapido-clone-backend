package com.rapido.search.repository;

import com.rapido.search.model.LocationDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LocationRepository
        extends ElasticsearchRepository<LocationDocument, String> {

    List<LocationDocument> findByNameContainingIgnoreCase(String name);
}