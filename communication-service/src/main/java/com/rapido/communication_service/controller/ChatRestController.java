package com.rapido.communication_service.controller;

import com.rapido.communication_service.entity.ChatMessage;
import com.rapido.communication_service.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatRestController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/history/{rideId}")
    public Page<ChatMessage> getChatHistory(
            @PathVariable Long rideId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {

        return chatService.getChatHistory(
                rideId,
                page,
                size
        );
    }

    @GetMapping("/offline/{receiverId}")
    public List<ChatMessage> getOfflineMessages(
            @PathVariable Long receiverId
    ) {

        return chatService.getOfflineMessages(receiverId);
    }
}