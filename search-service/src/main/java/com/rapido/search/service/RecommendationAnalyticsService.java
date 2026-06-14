package com.rapido.search.service;

import com.rapido.search.dto.RecommendationAnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class RecommendationAnalyticsService {

    public RecommendationAnalyticsResponse getAnalytics() {

        RecommendationAnalyticsResponse response =
                new RecommendationAnalyticsResponse();

        response.setTotalRecommendationsServed(150);
        response.setTotalRecommendationClicks(95);
        response.setClickThroughRate("63%");
        response.setMostRecommendedLocation("Charminar");

        return response;
    }
}