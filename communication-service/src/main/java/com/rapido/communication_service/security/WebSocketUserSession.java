package com.rapido.communication_service.security;

public class WebSocketUserSession {

    private static Long currentUserId;

    public static void setCurrentUserId(Long userId) {
        currentUserId = userId;
    }

    public static Long getCurrentUserId() {
        return currentUserId;
    }
}