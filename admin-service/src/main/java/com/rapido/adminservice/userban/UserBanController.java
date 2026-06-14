package com.rapido.adminservice.userban;

import com.rapido.adminservice.audit.AuditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
public class UserBanController {

    private final AuditService auditService;

    public UserBanController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/test")
    public String test() {
        return "User Ban Controller Working";
    }

    @PutMapping("/{userId}/ban")
    public UserBanResponse banUser(
            @PathVariable Long userId,
            @RequestParam String banType,
            @RequestParam String reason) {

        auditService.log(
                "admin@rapido.com",
                "USER_BAN",
                "User " + userId + " banned. Type: " + banType + ", Reason: " + reason
        );

        return new UserBanResponse(
                userId,
                banType,
                reason,
                "User banned successfully"
        );
    }
}