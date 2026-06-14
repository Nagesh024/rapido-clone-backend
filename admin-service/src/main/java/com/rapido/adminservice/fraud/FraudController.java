package com.rapido.adminservice.fraud;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/fraud")
public class FraudController {

    private final FraudDetectionService fraudDetectionService;
    private final FraudAlertRepository fraudAlertRepository;

    public FraudController(FraudDetectionService fraudDetectionService,
                           FraudAlertRepository fraudAlertRepository) {
        this.fraudDetectionService = fraudDetectionService;
        this.fraudAlertRepository = fraudAlertRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Fraud Controller Working";
    }

    @PostMapping("/simulate/fake-ride/{userId}")
    public FraudAlert simulateFakeRide(@PathVariable Long userId) {
        return fraudDetectionService.detectFakeRide(userId);
    }

    @PostMapping("/simulate/payment/{userId}")
    public FraudAlert simulatePaymentFraud(@PathVariable Long userId) {
        return fraudDetectionService.detectPaymentFraud(userId);
    }

    @GetMapping("/alerts")
    public List<FraudAlert> getAlerts() {
        return fraudAlertRepository.findAll();
    }
}