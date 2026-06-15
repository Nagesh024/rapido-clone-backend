package com.rapido.backupservice.backup;

import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaBackupService {

    @Scheduled(cron = "0 0 * * * *")
    public void backupTopics() {

        Properties props = new Properties();

        props.put(
                "bootstrap.servers",
                "localhost:9092");

        try (AdminClient admin =
                     AdminClient.create(props)) {

            admin.listTopics()
                    .names()
                    .get();

            System.out.println(
                    "Kafka backup metadata collected");
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}