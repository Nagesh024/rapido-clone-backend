package com.rapido.globalservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InternationalKafkaProducer {

    private final KafkaTemplate<String, Object>
            kafkaTemplate;

    public InternationalKafkaProducer(
            KafkaTemplate<String, Object> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(
            String topic,
            String eventType,
            String country,
            String currency,
            String language,
            String payload
    ) {

        InternationalEvent event =
                new InternationalEvent();

        event.setEventType(eventType);
        event.setCountry(country);
        event.setCurrency(currency);
        event.setLanguage(language);
        event.setPayload(payload);

        event.setEventTime(
                java.time.Instant.now().toString()
        );

        kafkaTemplate.send(
                topic,
                event
        );
    }
}