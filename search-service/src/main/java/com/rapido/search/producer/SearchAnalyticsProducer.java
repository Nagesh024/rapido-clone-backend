package com.rapido.search.producer;

import com.rapido.search.events.SearchAnalyticsEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchAnalyticsProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SearchAnalyticsProducer(
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(SearchAnalyticsEvent event) {

        String message =
                event.getEventType()
                + " | "
                + event.getSearchTerm()
                + " | "
                + event.getUserId();

        kafkaTemplate.send(
                "search-events",
                event.getEventType(),
                message
        );

        System.out.println(
                "SEARCH EVENT SENT -> "
                + message
        );
    }
}