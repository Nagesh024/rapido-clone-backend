package com.rapido.backupservice.dashboard;

public class DashboardMetrics {

    private String regionHealth;
    private String replicationLag;
    private String backupStatus;
    private String recoveryTime;
    private String failedServices;

    public DashboardMetrics(
            String regionHealth,
            String replicationLag,
            String backupStatus,
            String recoveryTime,
            String failedServices) {

        this.regionHealth = regionHealth;
        this.replicationLag = replicationLag;
        this.backupStatus = backupStatus;
        this.recoveryTime = recoveryTime;
        this.failedServices = failedServices;
    }

    public String getRegionHealth() {
        return regionHealth;
    }

    public String getReplicationLag() {
        return replicationLag;
    }

    public String getBackupStatus() {
        return backupStatus;
    }

    public String getRecoveryTime() {
        return recoveryTime;
    }

    public String getFailedServices() {
        return failedServices;
    }
}