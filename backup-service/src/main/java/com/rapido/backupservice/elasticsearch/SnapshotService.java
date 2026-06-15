package com.rapido.backupservice.elasticsearch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SnapshotService {

    @Scheduled(cron = "0 0 * * * *")
    public void createSnapshot() {

        System.out.println(
                "Elasticsearch Snapshot Created");

    }
}