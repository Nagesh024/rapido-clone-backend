package com.rapido.performanceservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncCommunicationService {

    @Async
    public void processRideEvent() {

        System.out.println("Async Ride Event Processing");

    }
}