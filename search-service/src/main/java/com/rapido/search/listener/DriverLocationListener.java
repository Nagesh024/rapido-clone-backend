package com.rapido.search.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapido.search.model.DriverDocument;
import com.rapido.search.repository.DriverSearchRepository;
import com.rapido.search.dto.DriverLocationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Service
public class DriverLocationListener {

    private final DriverSearchRepository repository;
    private final ObjectMapper objectMapper;

    public DriverLocationListener(DriverSearchRepository repository,
                                  ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "driver-location-updates", groupId = "search-service-group")
    public void consume(String message) {

        try {
            DriverLocationEvent event =
                    objectMapper.readValue(message, DriverLocationEvent.class);

            DriverDocument driver = repository.findById(event.getDriverId())
                    .orElse(new DriverDocument());

            driver.setDriverId(event.getDriverId());
            driver.setRating(driver.getRating());
            driver.setName(driver.getName());
            driver.setVehicleType(driver.getVehicleType());

            driver.setLocation(new GeoPoint(
                    event.getLat(),
                    event.getLon()
            ));

            repository.save(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}