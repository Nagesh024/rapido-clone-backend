package com.rapido.backupservice.backup;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchBackupService {

    @Scheduled(cron = "0 0 * * * *")
    public void createSnapshot() {

        System.out.println(
                "Elasticsearch snapshot created");
    }
}