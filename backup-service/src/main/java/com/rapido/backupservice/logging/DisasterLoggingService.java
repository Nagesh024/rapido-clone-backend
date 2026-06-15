package com.rapido.backupservice.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DisasterLoggingService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    DisasterLoggingService.class);

    public String failoverStarted() {

        log.info("Failover Started");

        return "Failover Started";
    }

    public String failoverCompleted() {

        log.info("Failover Completed");

        return "Failover Completed";
    }

    public String backupCreated() {

        log.info("Backup Created");

        return "Backup Created";
    }

    public String restoreStarted() {

        log.info("Restore Started");

        return "Restore Started";
    }

    public String restoreCompleted() {

        log.info("Restore Completed");

        return "Restore Completed";
    }

    public String replicationFailure() {

        log.error("Replication Failure");

        return "Replication Failure Logged";
    }
}