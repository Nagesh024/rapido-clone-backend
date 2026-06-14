package com.rapido.notificationservice.repository;

import com.rapido.notificationservice.entity.Notification;
import com.rapido.notificationservice.entity.NotificationStatus;
import com.rapido.notificationservice.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);

    List<Notification> findByType(NotificationType type);

    List<Notification> findByStatus(NotificationStatus status);
}