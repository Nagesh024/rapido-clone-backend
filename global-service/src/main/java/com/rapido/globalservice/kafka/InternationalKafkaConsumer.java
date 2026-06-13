package com.rapido.globalservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InternationalKafkaConsumer {

    @KafkaListener(
            topics = "international-events",
            groupId = "global-service"
    )
    public void consume(
            InternationalEvent event
    ) {

        System.out.println(
                "Event Received: "
                        + event.getEventType()
        );

        System.out.println(
                "Country: "
                        + event.getCountry()
        );

        System.out.println(
                "Currency: "
                        + event.getCurrency()
        );

        System.out.println(
                "Language: "
                        + event.getLanguage()
        );
    }
}