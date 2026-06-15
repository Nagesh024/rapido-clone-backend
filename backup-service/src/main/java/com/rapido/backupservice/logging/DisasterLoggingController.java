package com.rapido.backupservice.logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisasterLoggingController {

    private final DisasterLoggingService loggingService;

    public DisasterLoggingController(
            DisasterLoggingService loggingService) {

        this.loggingService = loggingService;
    }

    @GetMapping("/logs/failover-start")
    public String failoverStart() {

        return loggingService.failoverStarted();
    }

    @GetMapping("/logs/failover-complete")
    public String failoverComplete() {

        return loggingService.failoverCompleted();
    }

    @GetMapping("/logs/backup-created")
    public String backupCreated() {

        return loggingService.backupCreated();
    }

    @GetMapping("/logs/restore-start")
    public String restoreStart() {

        return loggingService.restoreStarted();
    }

    @GetMapping("/logs/restore-complete")
    public String restoreComplete() {

        return loggingService.restoreCompleted();
    }

    @GetMapping("/logs/replication-failure")
    public String replicationFailure() {

        return loggingService.replicationFailure();
    }
}