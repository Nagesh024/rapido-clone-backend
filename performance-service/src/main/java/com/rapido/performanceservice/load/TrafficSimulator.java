package com.rapido.performanceservice.load;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TrafficSimulator {

    private final WebClient webClient;

    public TrafficSimulator(WebClient webClient) {
        this.webClient = webClient;
    }

    @PostConstruct
    public void startLoad() {

        int concurrentUsers = 1000;

        ExecutorService executor =
                Executors.newFixedThreadPool(500);

        for(int i=0;i<concurrentUsers;i++) {

            executor.submit(() -> {

                try {

                    webClient.post()
                            .uri("/api/auth/login")
                            .bodyValue("""
                            {
                              "email":"user1@rapido.com",
                              "password":"password"
                            }
                            """)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();

                } catch (Exception ignored) {
                }
            });
        }
    }
}