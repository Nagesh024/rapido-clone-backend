package com.rapido.globalservice.notification;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final LocalizedNotificationService service;

    public NotificationController(
            LocalizedNotificationService service
    ) {
        this.service = service;
    }

    @GetMapping
    public NotificationResponse getNotification(

            @RequestParam String type,

            @RequestParam String language,

            @RequestParam(
                    required = false
            )
            String otp
    ) {

        String message =
                service.generateMessage(
                        NotificationType.valueOf(type),
                        language,
                        otp
                );

        return new NotificationResponse(
                language,
                message
        );
    }
}