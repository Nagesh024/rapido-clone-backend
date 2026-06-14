package com.rapido.search.repository;

import com.rapido.search.model.RideHistoryDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RideHistoryRepository
        extends ElasticsearchRepository<RideHistoryDocument, String> {

    List<RideHistoryDocument> findByUserId(Long userId);
}