package com.rapido.backupservice.backup;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//import com.rapido.backupservice.storage.BackupUploadService;

@Service
public class PostgreSqlBackupService {
//	private final BackupUploadService backupUploadService;
//
//	public PostgreSqlBackupService(
//	        BackupUploadService backupUploadService) {
//
//	    this.backupUploadService =
//	            backupUploadService;
//	}
    @Scheduled(cron = "0 0 * * * *")
    public void hourlyBackup() {

        try {

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            "pg_dump",
                            "-h",
                            "localhost",
                            "-p",
                            "5432",
                            "-U",
                            "postgres",
                            "-F",
                            "c",
                            "-f",
                            "backups/postgres/hourly.backup",
                            "rapidodb");

            processBuilder.environment()
                    .put("PGPASSWORD", "postgres");

            processBuilder.start();

            System.out.println(
                    "PostgreSQL backup completed");

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}