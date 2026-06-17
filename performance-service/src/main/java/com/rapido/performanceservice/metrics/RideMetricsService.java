<<<<<<< HEAD
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
=======
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
>>>>>>> 7428535d3931939c46580f8662fc1028b5c7abd9
}