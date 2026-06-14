package com.rapido.communication_service.service;

import com.rapido.communication_service.dto.ChatMessageDTO;
import com.rapido.communication_service.entity.ChatMessage;
import com.rapido.communication_service.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessageDTO dto) {

        ChatMessage message = new ChatMessage();

        message.setRideId(dto.getRideId());
        message.setSenderId(dto.getSenderId());
        message.setReceiverId(dto.getReceiverId());
        message.setMessage(dto.getMessage());
        message.setDelivered(true);
        message.setRead(false);
        message.setSentAt(LocalDateTime.now());

        return chatMessageRepository.save(message);
    }

    public Page<ChatMessage> getChatHistory(
            Long rideId,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return chatMessageRepository
                .findByRideIdOrderBySentAtAsc(rideId, pageable);
    }

    public List<ChatMessage> getOfflineMessages(Long receiverId) {

        return chatMessageRepository
                .findByReceiverIdAndDeliveredFalse(receiverId);
    }

    public void markMessagesAsRead(
            Long rideId,
            Long receiverId
    ) {

        List<ChatMessage> messages =
                chatMessageRepository
                        .findByRideIdAndReceiverIdAndReadFalse(
                                rideId,
                                receiverId
                        );

        for (ChatMessage message : messages) {
            message.setRead(true);
        }

        chatMessageRepository.saveAll(messages);
    }
}