package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.IncidentPriorityResponse;
import org.springframework.stereotype.Service;

@Service
public class IncidentPriorityService {

    public IncidentPriorityResponse calculatePriority() {

        IncidentPriorityResponse response =
                new IncidentPriorityResponse();

        response.setBusinessImpact(95);
        response.setAffectedUsers(88);
        response.setRevenueImpact(82);
        response.setSecurityRisk(91);

        int score =
                (response.getBusinessImpact()
                + response.getAffectedUsers()
                + response.getRevenueImpact()
                + response.getSecurityRisk()) / 4;

        response.setPriorityScore(score);

        if(score >= 90){
            response.setPriorityLevel("CRITICAL");
        }
        else if(score >= 75){
            response.setPriorityLevel("HIGH");
        }
        else if(score >= 50){
            response.setPriorityLevel("MEDIUM");
        }
        else{
            response.setPriorityLevel("LOW");
        }

        return response;
    }
}