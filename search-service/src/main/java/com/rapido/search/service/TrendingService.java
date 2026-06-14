package com.rapido.search.service;

import com.rapido.search.dto.TrendingResponse;
import com.rapido.search.model.SearchEvent;
import com.rapido.search.repository.SearchEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TrendingService {

    private final SearchEventRepository repository;

    public TrendingService(
            SearchEventRepository repository) {
        this.repository = repository;
    }

    @Cacheable("trending")
    public TrendingResponse getTrending() {

        System.out.println("FETCHING TRENDING FROM DATABASE");

        TrendingResponse response =
                new TrendingResponse();

        response.setToday(
                topDestinations(LocalDateTime.now().minusDays(1))
        );

        response.setWeekly(
                topDestinations(LocalDateTime.now().minusDays(7))
        );

        response.setMonthly(
                topDestinations(LocalDateTime.now().minusDays(30))
        );

        return response;
    }

    private List<String> topDestinations(
            LocalDateTime since) {

        List<SearchEvent> events =
                repository.findByCreatedAtAfter(since);

        Map<String, Long> counts =
                events.stream()
                        .collect(Collectors.groupingBy(
                                SearchEvent::getSelectedResult,
                                Collectors.counting()
                        ));

        return counts.entrySet()
                .stream()
                .sorted((a,b) ->
                        Long.compare(
                                b.getValue(),
                                a.getValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }
}