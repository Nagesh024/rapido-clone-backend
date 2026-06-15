package com.rapido.globalservice.kafka;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaEventController {

    private final InternationalKafkaProducer
            producer;

    public KafkaEventController(
            InternationalKafkaProducer producer
    ) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public String publish(
            @RequestBody
            KafkaEventRequest request
    ) {

        producer.publishEvent(
                "international-events",
                request.getEventType(),
                request.getCountry(),
                request.getCurrency(),
                request.getLanguage(),
                request.getPayload()
        );

        return "Event Published";
    }
}