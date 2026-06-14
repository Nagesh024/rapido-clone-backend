package com.rapido.search.service;

import com.rapido.search.model.DriverDocument;
import com.rapido.search.repository.DriverSearchRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Service
public class SearchService {

    private final DriverSearchRepository repository;
    private final ElasticsearchOperations elasticsearchOperations;

    public SearchService(DriverSearchRepository repository,
                         ElasticsearchOperations elasticsearchOperations) {
        this.repository = repository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public DriverDocument indexDriver(DriverDocument driver) {
        return repository.save(driver);
    }

    public Optional<DriverDocument> getDriver(String id) {
        return repository.findById(id);
    }

    // ✅ SAFE GEO SEARCH (FINAL STABLE VERSION)
    public List<DriverDocument> findNearbyDrivers(double lat, double lon, double radiusKm) {

        Criteria criteria = new Criteria("location")
                .within(new GeoPoint(lat, lon), radiusKm + "km");

        CriteriaQuery query = new CriteriaQuery(criteria);

        SearchHits<DriverDocument> hits =
                elasticsearchOperations.search(query, DriverDocument.class);

        return hits.getSearchHits()
                .stream()
                .map(hit -> hit.getContent())
                .toList();
    }
}