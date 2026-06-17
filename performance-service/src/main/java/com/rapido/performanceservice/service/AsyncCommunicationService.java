<<<<<<< HEAD
package com.rapido.performanceservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncCommunicationService {

    @Async
    public void processRideEvent() {

        System.out.println("Async Ride Event Processing");

    }
=======
package com.rapido.performanceservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncCommunicationService {

    @Async
    public void processRideEvent() {

        System.out.println("Async Ride Event Processing");

    }
>>>>>>> 7428535d3931939c46580f8662fc1028b5c7abd9
}