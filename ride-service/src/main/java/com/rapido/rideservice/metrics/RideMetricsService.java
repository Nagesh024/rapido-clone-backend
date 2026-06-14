package com.rapido.rideservice.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class RideMetricsService {

    private final Counter rideRequestCounter;
    private final Counter rideSuccessCounter;
    private final Counter rideFailureCounter;

    public RideMetricsService(MeterRegistry meterRegistry) {
        this.rideRequestCounter = Counter.builder("ride_requests_total")
                .description("Total ride requests received")
                .register(meterRegistry);

        this.rideSuccessCounter = Counter.builder("ride_success_total")
                .description("Total successful ride matches")
                .register(meterRegistry);

        this.rideFailureCounter = Counter.builder("ride_failure_total")
                .description("Total failed ride matches")
                .register(meterRegistry);
    }

    public void incrementRideRequests() {
        rideRequestCounter.increment();
    }

    public void incrementRideSuccess() {
        rideSuccessCounter.increment();
    }

    public void incrementRideFailure() {
        rideFailureCounter.increment();
    }
}