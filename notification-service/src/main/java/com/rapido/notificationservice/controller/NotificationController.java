package com.rapido.notificationservice.controller;

import com.rapido.notificationservice.dto.ApiResponse;
import com.rapido.notificationservice.dto.NotificationEvent;
import com.rapido.notificationservice.entity.Notification;
import com.rapido.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ApiResponse<Notification> sendNotification(
            @RequestBody NotificationEvent event
    ) {

        Notification notification =
                notificationService.sendNotification(event);

        return new ApiResponse<>(
                true,
                "Notification Sent Successfully",
                notification
        );
    }

    @GetMapping("/history")
    public ApiResponse<?> getHistory() {

        return new ApiResponse<>(
                true,
                "Notification History Fetched Successfully",
                notificationService.getAllNotifications()
        );
    }
    @PostMapping("/otp")
    public ApiResponse<?> sendOtp(
            @RequestParam String phone
    ) {

        String otp =
                com.rapido.notificationservice.util.OtpGenerator.generateOtp();

        return new ApiResponse<>(
                true,
                "OTP Generated Successfully",
                otp
        );
    }
}