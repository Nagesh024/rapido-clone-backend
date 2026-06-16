package com.rapido.performanceservice.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

@Service
public class RideMetricsService {

    private final Timer rideMatchingTimer;
    private final Timer paymentTimer;

    public RideMetricsService(MeterRegistry registry) {

        this.rideMatchingTimer =
                Timer.builder("ride_matching_latency")
                        .publishPercentileHistogram()
                        .register(registry);

        this.paymentTimer =
                Timer.builder("payment_processing_latency")
                        .publishPercentileHistogram()
                        .register(registry);
    }

    public Timer getRideMatchingTimer() {
        return rideMatchingTimer;
    }

    public Timer getPaymentTimer() {
        return paymentTimer;
    }
}