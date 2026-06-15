package com.rapido.backupservice.velero;

import org.springframework.stereotype.Service;

@Service
public class VeleroBackupService {

    public String createBackup() {

        System.out.println(
                "Velero Backup Started");

        return "Velero Backup Completed";
    }

    public String restoreBackup() {

        System.out.println(
                "Velero Restore Started");

        return "Velero Restore Completed";
    }
}