package com.rapido.backupservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapido.backupservice.recovery.PITRService;

@RestController
public class RecoveryController {

    private final PITRService pitrService;

    public RecoveryController(
            PITRService pitrService) {

        this.pitrService = pitrService;
    }

    @GetMapping("/recovery/pitr")
    public String restore() {

        pitrService.restoreDatabase();

        return "PITR Started";
    }
}