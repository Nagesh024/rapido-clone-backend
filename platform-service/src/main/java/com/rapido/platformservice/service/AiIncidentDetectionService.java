package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.AiIncidentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AiIncidentDetectionService {

    public AiIncidentResponse detectIncidents() {

        AiIncidentResponse response = new AiIncidentResponse();

        double traffic = 91;
        int failedLogins = 125;
        int suspiciousPayments = 7;
        int suspiciousRides = 4;
        double cpu = 92;

        response.setAbnormalTraffic(traffic > 85);
        response.setUnexpectedLoginPattern(failedLogins > 100);
        response.setPaymentFraud(suspiciousPayments > 5);
        response.setRideFraud(suspiciousRides > 3);
        response.setResourceSpike(cpu > 90);

        int score = 0;

        if(response.isAbnormalTraffic()) score += 20;
        if(response.isUnexpectedLoginPattern()) score += 20;
        if(response.isPaymentFraud()) score += 20;
        if(response.isRideFraud()) score += 20;
        if(response.isResourceSpike()) score += 20;

        response.setAiRiskScore(score);

        if(score >= 80)
            response.setSeverity("CRITICAL");
        else if(score >= 60)
            response.setSeverity("HIGH");
        else if(score >= 40)
            response.setSeverity("MEDIUM");
        else
            response.setSeverity("LOW");

        List<String> alerts = new ArrayList<>();

        if(response.isAbnormalTraffic())
            alerts.add("AI Alert : Abnormal traffic detected");

        if(response.isUnexpectedLoginPattern())
            alerts.add("AI Alert : Unexpected login pattern");

        if(response.isPaymentFraud())
            alerts.add("AI Alert : Possible payment fraud");

        if(response.isRideFraud())
            alerts.add("AI Alert : Possible ride fraud");

        if(response.isResourceSpike())
            alerts.add("AI Alert : Infrastructure resource spike");

        response.setAlerts(alerts);

        return response;
    }
}