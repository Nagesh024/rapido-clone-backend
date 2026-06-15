package com.rapido.backupservice.alerting;

import org.springframework.stereotype.Service;

@Service
public class AlertingService {

    public String regionAlert() {

        System.out.println("ALERT : Region Down");

        return "Region Down Alert Triggered";
    }

    public String replicationLagAlert() {

        System.out.println("ALERT : Replication Lag");

        return "Replication Lag Alert Triggered";
    }

    public String backupFailureAlert() {

        System.out.println("ALERT : Backup Failure");

        return "Backup Failure Alert Triggered";
    }

    public String errorRateAlert() {

        System.out.println("ALERT : High Error Rate");

        return "High Error Rate Alert Triggered";
    }

    public String recoveryFailureAlert() {

        System.out.println("ALERT : Recovery Failure");

        return "Recovery Failure Alert Triggered";
    }
}