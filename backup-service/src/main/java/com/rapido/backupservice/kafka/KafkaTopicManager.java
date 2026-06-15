package com.rapido.backupservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicManager {

    @Bean
    public NewTopic rideEvents() {

        return new NewTopic(
                "ride-events",
                3,
                (short) 3);
    }

    @Bean
    public NewTopic paymentEvents() {

        return new NewTopic(
                "payment-events",
                3,
                (short) 3);
    }

    @Bean
    public NewTopic notificationEvents() {

        return new NewTopic(
                "notification-events",
                3,
                (short) 3);
    }
}