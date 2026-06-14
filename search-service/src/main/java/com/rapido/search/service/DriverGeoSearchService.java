package com.rapido.search.service;

import com.rapido.search.model.DriverDocument;
import com.rapido.search.repository.DriverSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverGeoSearchService {

    private final DriverSearchRepository repository;
    private final DriverRankingService rankingService;

    public DriverGeoSearchService(
            DriverSearchRepository repository,
            DriverRankingService rankingService) {

        this.repository = repository;
        this.rankingService = rankingService;
    }

    public List<DriverDocument> findNearbyDrivers(
            String status) {

        List<DriverDocument> drivers =
                repository.findByStatus(status);

        return rankingService.rankDrivers(drivers);
    }
}