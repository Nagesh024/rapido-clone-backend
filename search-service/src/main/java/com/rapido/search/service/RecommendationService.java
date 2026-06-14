package com.rapido.search.service;

import com.rapido.search.dto.RideRecommendationResponse;
import com.rapido.search.model.RideHistoryDocument;
import com.rapido.search.repository.RideHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final RideHistoryRepository repository;

    public RecommendationService(
            RideHistoryRepository repository) {
        this.repository = repository;
    }

    public RideRecommendationResponse recommend(
            Long userId) {

        List<RideHistoryDocument> history =
                repository.findByUserId(userId);

        if(history.isEmpty()) {

            return new RideRecommendationResponse(
                    "Madhapur",
                    "Airport",
                    "Bike"
            );
        }

        RideHistoryDocument lastRide =
                history.get(history.size() - 1);

        return new RideRecommendationResponse(
                lastRide.getPickup(),
                lastRide.getDestination(),
                lastRide.getRideType()
        );
    }
}