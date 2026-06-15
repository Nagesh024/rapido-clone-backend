package com.rapido.backupservice.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final DatabaseFailoverService service;

    public DatabaseController(
            DatabaseFailoverService service) {

        this.service = service;
    }

    @GetMapping("/database/failover")
    public String failover() {

        return service.switchDatabase();
    }
}