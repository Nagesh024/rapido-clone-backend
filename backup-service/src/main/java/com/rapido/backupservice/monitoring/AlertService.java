package com.rapido.backupservice.monitoring;

import org.springframework.stereotype.Service;

@Service
public class AlertService {

    public String triggerAlert() {

        System.out.println("Recovery Alert Triggered");

        return "Alert Sent";
    }
}