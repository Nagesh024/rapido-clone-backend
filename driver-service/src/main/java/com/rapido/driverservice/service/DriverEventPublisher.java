package com.rapido.driverservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapido.driverservice.dto.DriverLocationEvent;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DriverEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishDriverUpdate(DriverLocationEvent event) {
        try {
            String message = objectMapper.writeValueAsString(event);

            kafkaTemplate.send("driver-location-updates", message);

        } catch (Exception e) {
            throw new RuntimeException("Failed to publish event", e);
        }
    }
}