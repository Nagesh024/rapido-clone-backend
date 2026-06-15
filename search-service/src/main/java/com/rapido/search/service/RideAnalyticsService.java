package com.rapido.search.service;

import com.rapido.search.dto.RideAnalyticsResponse;
import com.rapido.search.model.RideHistoryDocument;
import com.rapido.search.repository.RideHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RideAnalyticsService {

    private final RideHistoryRepository repository;

    public RideAnalyticsService(
            RideHistoryRepository repository) {
        this.repository = repository;
    }

    public RideAnalyticsResponse analyze(
            Long userId) {

        List<RideHistoryDocument> rides =
                repository.findByUserId(userId);

        long totalRides = rides.size();

        String mostVisited =
                rides.stream()
                        .collect(Collectors.groupingBy(
                                RideHistoryDocument::getDestination,
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("N/A");

        return new RideAnalyticsResponse(
                totalRides,
                mostVisited
        );
    }
}