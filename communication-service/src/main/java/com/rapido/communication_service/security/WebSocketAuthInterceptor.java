package com.rapido.communication_service.security;

import io.jsonwebtoken.Claims;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.net.URI;
import java.util.Map;

public class WebSocketAuthInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes
    ) {

        URI uri = request.getURI();
        String query = uri.getQuery();

        System.out.println("WebSocket Auth Query: " + query);

        if (query == null || !query.contains("token=")) {
            System.out.println("WebSocket blocked: token missing");
            return false;
        }

        String token = query.substring(query.indexOf("token=") + 6);

        if (token.contains("&")) {
            token = token.substring(0, token.indexOf("&"));
        }

        try {
            Claims claims = JwtUtil.validateToken(token);

            attributes.put("userId", claims.getSubject());

            System.out.println("WebSocket allowed for user: " + claims.getSubject());

            return true;

        } catch (Exception e) {
            System.out.println("WebSocket blocked: invalid token");
            return false;
        }
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Exception exception
    ) {
    }
}