package com.rapido.communication_service.websocket;

import com.rapido.communication_service.dto.*;
import com.rapido.communication_service.redis.RedisMessagePublisher;
import com.rapido.communication_service.entity.ChatMessage;
import com.rapido.communication_service.service.ChatService;
import com.rapido.communication_service.service.RideAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatWebSocketController {

    @Autowired
    private RideAuthorizationService rideAuthorizationService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessageDTO messageDTO) {

    	Long loggedInUserId =
    	        com.rapido.communication_service.security.WebSocketUserSession.getCurrentUserId();
        System.out.println("JWT User: " + loggedInUserId);
        System.out.println("Payload Sender: " + messageDTO.getSenderId());

        if (!loggedInUserId.equals(messageDTO.getSenderId())) {
            System.out.println("Blocked: senderId does not match JWT user");
            return;
        }

        boolean authorized = rideAuthorizationService.isAuthorized(
                messageDTO.getRideId(),
                loggedInUserId
        );

        if (!authorized) {
            System.out.println("Unauthorized ride access attempt: " + loggedInUserId);
            return;
        }

        ChatMessage savedMessage = chatService.saveMessage(messageDTO);
        redisMessagePublisher.publish(
                "RideId: " + messageDTO.getRideId()
                        + ", SenderId: " + messageDTO.getSenderId()
                        + ", Message: " + messageDTO.getMessage()
        );
        messagingTemplate.convertAndSend(
                "/topic/chat/" + messageDTO.getRideId(),
                savedMessage
        );

        System.out.println("Message sent for rideId: " + messageDTO.getRideId());
    }

    @MessageMapping("/chat.typing")
    public void typing(TypingDTO typingDTO) {

        messagingTemplate.convertAndSend(
                "/topic/typing/" + typingDTO.getRideId(),
                typingDTO
        );

        System.out.println("Typing event for rideId: " + typingDTO.getRideId());
    }

    @MessageMapping("/chat.read")
    public void readReceipt(ReadReceiptDTO readReceiptDTO) {

        chatService.markMessagesAsRead(
                readReceiptDTO.getRideId(),
                readReceiptDTO.getReceiverId()
        );

        messagingTemplate.convertAndSend(
                "/topic/read-receipt/" + readReceiptDTO.getRideId(),
                readReceiptDTO
        );

        System.out.println("Read receipt received for rideId: " + readReceiptDTO.getRideId());
    }
}