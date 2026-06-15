package com.rapido.backupservice.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private final BackupEncryptionService encryptionService;
    private final SecretRecoveryService secretRecoveryService;
    private final IamValidationService iamValidationService;
    private final AuditLogService auditLogService;

    public SecurityController(
            BackupEncryptionService encryptionService,
            SecretRecoveryService secretRecoveryService,
            IamValidationService iamValidationService,
            AuditLogService auditLogService) {

        this.encryptionService = encryptionService;
        this.secretRecoveryService = secretRecoveryService;
        this.iamValidationService = iamValidationService;
        this.auditLogService = auditLogService;
    }

    @GetMapping("/security/encrypt")
    public String encrypt() {

        return encryptionService.encryptBackup();
    }

    @GetMapping("/security/secrets")
    public String secrets() {

        return secretRecoveryService.recoverSecrets();
    }

    @GetMapping("/security/iam")
    public String iam() {

        return iamValidationService.validatePermissions();
    }

    @GetMapping("/security/audit")
    public String audit() {

        return auditLogService.createAuditLog();
    }
}