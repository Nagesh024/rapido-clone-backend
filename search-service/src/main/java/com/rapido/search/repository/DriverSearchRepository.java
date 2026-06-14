package com.rapido.search.repository;

import com.rapido.search.model.DriverDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DriverSearchRepository
        extends ElasticsearchRepository<DriverDocument, String> {

    List<DriverDocument> findByStatus(String status);
}