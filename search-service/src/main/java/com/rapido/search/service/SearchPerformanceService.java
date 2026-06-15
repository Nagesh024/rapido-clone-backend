package com.rapido.search.service;

import com.rapido.search.dto.SearchPerformanceResponse;
import org.springframework.stereotype.Service;

@Service
public class SearchPerformanceService {

    public SearchPerformanceResponse getPerformance() {

        SearchPerformanceResponse response =
                new SearchPerformanceResponse();

        response.setAverageSearchLatency("45 ms");
        response.setCacheHitRatio("82%");
        response.setQueryThroughput("120 req/min");
        response.setElasticsearchResponseTime("18 ms");

        return response;
    }
}