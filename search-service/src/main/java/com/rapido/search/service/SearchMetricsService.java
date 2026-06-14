package com.rapido.search.service;

import com.rapido.search.dto.SearchMetricsResponse;
import com.rapido.search.repository.DriverSearchRepository;
import com.rapido.search.repository.LocationRepository;
import com.rapido.search.repository.SearchEventRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchMetricsService {

    private final SearchEventRepository searchRepository;
    private final LocationRepository locationRepository;
    private final DriverSearchRepository driverRepository;

    public SearchMetricsService(
            SearchEventRepository searchRepository,
            LocationRepository locationRepository,
            DriverSearchRepository driverRepository) {

        this.searchRepository = searchRepository;
        this.locationRepository = locationRepository;
        this.driverRepository = driverRepository;
    }

    public SearchMetricsResponse metrics() {

        SearchMetricsResponse response =
                new SearchMetricsResponse();

        response.setTotalSearches(
                searchRepository.count()
        );

        response.setTotalLocations(
                locationRepository.count()
        );

        response.setTotalDrivers(
                driverRepository.count()
        );

        // Demo counters
        response.setAutocompleteRequests(10);
        response.setFuzzySearchRequests(5);

        return response;
    }
}