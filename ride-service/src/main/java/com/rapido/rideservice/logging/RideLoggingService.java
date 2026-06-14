package com.rapido.rideservice.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RideLoggingService {

    private static final Logger log =
            LoggerFactory.getLogger(RideLoggingService.class);

    public void logDriverMatched(Long rideId, Long driverId) {

        log.info("""
                DRIVER MATCHED
                Ride ID: {}
                Driver ID: {}
                """,
                rideId,
                driverId
        );
    }

    public void logSurgeApplied(double surgeMultiplier) {

        log.info("""
                SURGE APPLIED
                Surge Multiplier: {}
                """,
                surgeMultiplier
        );
    }

    public void logRideTimeout(Long rideId) {

        log.warn("""
                RIDE TIMEOUT
                Ride ID: {}
                """,
                rideId
        );
    }

    public void logAllocationFailure(String reason) {

        log.error("""
                DRIVER ALLOCATION FAILED
                Reason: {}
                """,
                reason
        );
    }
}