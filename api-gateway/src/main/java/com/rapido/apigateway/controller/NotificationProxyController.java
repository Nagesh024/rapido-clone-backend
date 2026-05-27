package com.rapido.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class NotificationProxyController {

    @GetMapping("/notifications/health")
    public ResponseEntity<String> health() {

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://notification-service:8086/notifications/health"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return ResponseEntity
                    .status(response.statusCode())
                    .body(response.body());

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Notification service not reachable: " + e.getMessage());
        }
    }
}