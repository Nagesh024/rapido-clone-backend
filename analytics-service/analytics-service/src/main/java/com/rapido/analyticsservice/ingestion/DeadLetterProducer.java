package com.rapido.analyticsservice.ingestion;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public DeadLetterProducer(
            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void publish(
            String message) {

        kafkaTemplate.send(
                "analytics-dlt",
                message);
    }
}