package com.rapido.platformengineering.dto;

public record DisasterRecoveryResponse(

        String gitopsBackup,
        String terraformBackup,
        String databaseBackup,
        String recoveryRunbook

) {
}