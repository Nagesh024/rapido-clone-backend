package com.rapido.search.service;

import com.rapido.search.events.SearchAnalyticsEvent;
import com.rapido.search.model.SearchEvent;
import com.rapido.search.producer.SearchAnalyticsProducer;
import com.rapido.search.repository.SearchEventRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchAnalyticsService {

    private final SearchEventRepository repository;
    private final SearchAnalyticsProducer producer;
    private final SearchAuditService auditService;

    public SearchAnalyticsService(
            SearchEventRepository repository,
            SearchAnalyticsProducer producer,
            SearchAuditService auditService) {

        this.repository = repository;
        this.producer = producer;
        this.auditService = auditService;
    }

    public void saveEvent(
            String searchTerm,
            Long userId,
            String selectedResult,
            Long responseTime,
            String eventType) {

        SearchEvent event = new SearchEvent();

        event.setSearchTerm(searchTerm);
        event.setUserId(userId);
        event.setSelectedResult(selectedResult);
        event.setResponseTime(responseTime);
        event.setEventType(eventType);
        event.setCreatedAt(
                java.time.LocalDateTime.now()
        );

        repository.save(event);

        // Audit Log
        auditService.saveAudit(
                userId,
                searchTerm
        );

        // Kafka Event
        SearchAnalyticsEvent kafkaEvent =
                new SearchAnalyticsEvent();

        kafkaEvent.setEventType(eventType);
        kafkaEvent.setSearchTerm(searchTerm);
        kafkaEvent.setUserId(userId);

        producer.publish(kafkaEvent);
    }
}