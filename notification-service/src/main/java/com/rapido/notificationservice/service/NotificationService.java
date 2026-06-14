package com.rapido.notificationservice.service;

import com.rapido.notificationservice.dto.NotificationEvent;
import com.rapido.notificationservice.entity.Notification;
import com.rapido.notificationservice.entity.NotificationStatus;
import com.rapido.notificationservice.entity.NotificationType;
import com.rapido.notificationservice.repository.NotificationRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final SmsService smsService;
    private final EmailService emailService;
    private final SimpMessagingTemplate messagingTemplate;

    public NotificationService(
            NotificationRepository notificationRepository,
            SmsService smsService,
            EmailService emailService,
            SimpMessagingTemplate messagingTemplate
    ) {
        this.notificationRepository = notificationRepository;
        this.smsService = smsService;
        this.emailService = emailService;
        this.messagingTemplate = messagingTemplate;
    }

    public Notification sendNotification(NotificationEvent event) {

        Notification notification = new Notification();

        notification.setUserId(event.getUserId());
        notification.setType(event.getType());
        notification.setRecipient(event.getRecipient());
        notification.setTitle(event.getTitle());
        notification.setMessage(event.getMessage());

        boolean sent = false;

        if (event.getType() == NotificationType.SMS) {

            sent = smsService.sendSms(
                    event.getRecipient(),
                    event.getMessage()
            );

        } else if (event.getType() == NotificationType.EMAIL) {

            sent = emailService.sendEmail(
                    event.getRecipient(),
                    event.getTitle(),
                    event.getMessage()
            );
        }

        if (sent) {

            notification.setStatus(NotificationStatus.SENT);
            notification.setRetryCount(0);

        } else {

            notification.setStatus(NotificationStatus.RETRYING);

            int retryCount = 1;

            while (!sent && retryCount <= 3) {

                System.out.println(
                        "Retry Attempt : " + retryCount
                );

                if (event.getType() == NotificationType.SMS) {

                    sent = smsService.sendSms(
                            event.getRecipient(),
                            event.getMessage()
                    );
                }

                retryCount++;
            }

            if (sent) {
                notification.setStatus(NotificationStatus.SENT);
            } else {
                notification.setStatus(NotificationStatus.FAILED);
            }

            notification.setRetryCount(retryCount - 1);
        }

        notification.setCreatedAt(LocalDateTime.now());

        Notification savedNotification =
                notificationRepository.save(notification);

        messagingTemplate.convertAndSend(
                "/topic/notifications",
                savedNotification
        );

        return savedNotification;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}