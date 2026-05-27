package com.rapido.rideservice.scheduler;

import com.rapido.rideservice.entity.Ride;
import com.rapido.rideservice.entity.RideStatus;
import com.rapido.rideservice.optimization.RideReassignmentService;
import com.rapido.rideservice.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RideTimeoutScheduler {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RideReassignmentService reassignmentService;

    @Scheduled(fixedRate = 30000)
    public void checkPendingRideTimeouts() {

        LocalDateTime timeoutTime = LocalDateTime.now().minusMinutes(2);

        List<Ride> timedOutRides =
                rideRepository.findByStatusAndRequestedAtBefore(
                        RideStatus.REQUESTED,
                        timeoutTime
                );

        for (Ride ride : timedOutRides) {
            reassignmentService.reassignRide(ride);
        }
    }
}