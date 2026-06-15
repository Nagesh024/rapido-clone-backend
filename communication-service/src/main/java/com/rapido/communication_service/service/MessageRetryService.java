package com.rapido.communication_service.service;

import com.rapido.communication_service.dto.ChatMessageDTO;
import com.rapido.communication_service.entity.MessageRetry;
import com.rapido.communication_service.repository.MessageRetryRepository;
import com.rapido.communication_service.redis.RedisMessagePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageRetryService {

    @Autowired
    private MessageRetryRepository messageRetryRepository;

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    public void saveForRetry(ChatMessageDTO dto) {

        MessageRetry retry = new MessageRetry();

        retry.setRideId(dto.getRideId());
        retry.setSenderId(dto.getSenderId());
        retry.setReceiverId(dto.getReceiverId());
        retry.setMessage(dto.getMessage());
        retry.setStatus("PENDING");
        retry.setRetryCount(0);
        retry.setCreatedAt(LocalDateTime.now());

        messageRetryRepository.save(retry);

        System.out.println("Message stored in retry queue");
    }

    public void retryPendingMessages() {

        List<MessageRetry> pendingMessages =
                messageRetryRepository.findByStatus("PENDING");

        for (MessageRetry retry : pendingMessages) {

            try {
                redisMessagePublisher.publish(
                        "Retry RideId: " + retry.getRideId()
                                + ", SenderId: " + retry.getSenderId()
                                + ", Message: " + retry.getMessage()
                );

                retry.setStatus("SENT");
                retry.setLastRetryAt(LocalDateTime.now());

                messageRetryRepository.save(retry);

                System.out.println("Retry message sent successfully: " + retry.getId());

            } catch (Exception e) {

                retry.setRetryCount(retry.getRetryCount() + 1);
                retry.setLastRetryAt(LocalDateTime.now());

                messageRetryRepository.save(retry);

                System.out.println("Retry failed for message id: " + retry.getId());
            }
        }
    }
}