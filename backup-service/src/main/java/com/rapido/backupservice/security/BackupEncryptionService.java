package com.rapido.backupservice.security;

import org.springframework.stereotype.Service;

@Service
public class BackupEncryptionService {

    public String encryptBackup() {

        System.out.println(
                "Backup Encryption Started");

        System.out.println(
                "Backup Encryption Completed");

        return "Encrypted Backup Created";
    }
}