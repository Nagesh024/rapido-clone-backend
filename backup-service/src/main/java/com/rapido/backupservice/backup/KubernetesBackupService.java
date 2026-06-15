package com.rapido.backupservice.backup;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KubernetesBackupService {

    @Scheduled(cron = "0 0 0 * * *")
    public void backupCluster() {

        System.out.println(
                "Kubernetes configuration backup completed");
    }
}