package com.rapido.communication_service.repository;

import com.rapido.communication_service.entity.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository
        extends JpaRepository<ChatMessage, Long> {

    Page<ChatMessage> findByRideIdOrderBySentAtAsc(
            Long rideId,
            Pageable pageable
    );

    List<ChatMessage> findByReceiverIdAndDeliveredFalse(
            Long receiverId
    );

    List<ChatMessage> findByRideIdAndReceiverIdAndReadFalse(
            Long rideId,
            Long receiverId
    );
}