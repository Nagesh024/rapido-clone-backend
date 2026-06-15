package com.rapido.backupservice.velero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeleroController {

    private final VeleroBackupService service;

    public VeleroController(
            VeleroBackupService service) {

        this.service = service;
    }

    @GetMapping("/velero/backup")
    public String backup() {

        return service.createBackup();
    }

    @GetMapping("/velero/restore")
    public String restore() {

        return service.restoreBackup();
    }
}