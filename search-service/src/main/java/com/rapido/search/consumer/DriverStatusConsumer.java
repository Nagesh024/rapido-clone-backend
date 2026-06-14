package com.rapido.search.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapido.search.events.DriverStatusEvent;
import com.rapido.search.model.DriverDocument;
import com.rapido.search.repository.DriverSearchRepository;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DriverStatusConsumer {

    private final DriverSearchRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public DriverStatusConsumer(
            DriverSearchRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(
            topics = "driver-status-events",
            groupId = "search-service")
    public void consume(String message) {

        try {

            DriverStatusEvent event =
                    mapper.readValue(
                            message,
                            DriverStatusEvent.class
                    );

            System.out.println(
                    "Kafka Event Received: "
                    + event.getDriverId()
            );

            DriverDocument driver =
                    repository.findById(
                            event.getDriverId())
                            .orElse(new DriverDocument());

            driver.setDriverId(
                    event.getDriverId());

            driver.setStatus(
                    event.getStatus());

            driver.setLocation(
                    new GeoPoint(
                            event.getLatitude(),
                            event.getLongitude()
                    )
            );

            repository.save(driver);

            System.out.println(
                    "Saved to Elasticsearch: "
                    + event.getDriverId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}