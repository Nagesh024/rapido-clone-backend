package com.rapido.communication_service.config;

import com.rapido.communication_service.security.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.security.Principal;

public class WebSocketChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(
            Message<?> message,
            MessageChannel channel
    ) {

        StompHeaderAccessor accessor =
                StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {

            String token =
                    accessor.getFirstNativeHeader("Authorization");

            if (token == null || token.isEmpty()) {
                throw new RuntimeException("Missing JWT token");
            }

            token = token.replace("Bearer ", "");

            try {

                Claims claims =
                        JwtUtil.validateToken(token);

                String userId =
                        claims.getSubject();
                com.rapido.communication_service.security.WebSocketUserSession
                .setCurrentUserId(Long.parseLong(userId));
                accessor.setUser(new Principal() {
                    @Override
                    public String getName() {
                        return userId;
                    }
                });

                System.out.println(
                        "STOMP allowed user: " + userId
                );

            } catch (Exception e) {

                throw new RuntimeException(
                        "Invalid JWT token"
                );
            }
        }

        return message;
    }
}