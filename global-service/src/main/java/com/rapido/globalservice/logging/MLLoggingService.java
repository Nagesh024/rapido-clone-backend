package com.rapido.globalservice.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MLLoggingService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    MLLoggingService.class
            );

    public void generateLogs() {

        log.info("Model Trained");

        log.info("Prediction Generated");

        log.warn("Retraining Triggered");

        log.error("Data Drift Detected");
    }
}