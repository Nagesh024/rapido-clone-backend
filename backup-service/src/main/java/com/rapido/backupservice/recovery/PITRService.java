package com.rapido.backupservice.recovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PITRService {

    @Value("${postgres.data.path}")
    private String dataPath;

    @Value("${postgres.backup.path}")
    private String backupPath;

    @Value("${postgres.recovery.target.time}")
    private String recoveryTargetTime;

    public void restoreDatabase() {

        try {

            System.out.println("Starting PITR Recovery");

            ProcessBuilder baseBackup =
                    new ProcessBuilder(
                            "pg_basebackup",
                            "-D",
                            dataPath,
                            "-Fp",
                            "-Xs",
                            "-P");

            Process process =
                    baseBackup.start();

            process.waitFor();

            System.out.println(
                    "Base Backup Restore Completed");

            ProcessBuilder recovery =
                    new ProcessBuilder(
                            "cmd",
                            "/c",
                            "echo recovery_target_time='"
                                    + recoveryTargetTime
                                    + "' > "
                                    + dataPath
                                    + "\\recovery.signal");

            Process process2 =
                    recovery.start();

            process2.waitFor();

            System.out.println(
                    "Recovery Target Configured");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}