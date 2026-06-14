package com.rapido.adminservice.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    private static final Logger logger =
            LoggerFactory.getLogger(FraudDetectionService.class);

    private final FraudAlertRepository fraudAlertRepository;

    public FraudDetectionService(FraudAlertRepository fraudAlertRepository) {
        this.fraudAlertRepository = fraudAlertRepository;
    }

    public FraudAlert detectFakeRide(Long userId) {

        FraudAlert alert = new FraudAlert(
                userId,
                "FAKE_RIDE",
                "Same pickup/drop location repeated multiple times",
                "HIGH",
                false
        );

        FraudAlert savedAlert = fraudAlertRepository.save(alert);

        logger.warn("Fraud detected: FAKE_RIDE for userId {}", userId);

        return savedAlert;
    }

    public FraudAlert detectPaymentFraud(Long userId) {

        FraudAlert alert = new FraudAlert(
                userId,
                "PAYMENT_FRAUD",
                "Duplicate payment or refund abuse detected",
                "CRITICAL",
                false
        );

        FraudAlert savedAlert = fraudAlertRepository.save(alert);

        logger.warn("Fraud detected: PAYMENT_FRAUD for userId {}", userId);

        return savedAlert;
    }
}