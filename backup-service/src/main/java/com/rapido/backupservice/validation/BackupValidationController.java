package com.rapido.backupservice.validation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackupValidationController {

    private final BackupValidationService validationService;

    public BackupValidationController(
            BackupValidationService validationService) {

        this.validationService = validationService;
    }

    @GetMapping("/backup/validate")
    public String validateBackup() {

        return validationService.validateBackup();
    }
}