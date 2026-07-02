package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.RootCauseAnalysisResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootCauseAnalysisService {

    public RootCauseAnalysisResponse analyze() {

        RootCauseAnalysisResponse response =
                new RootCauseAnalysisResponse();

        double cpu = 94;
        double databaseConnections = 96;
        double networkLatency = 45;
        int applicationErrors = 12;

        List<String> evidence = new ArrayList<>();

        if(cpu > 90){
            response.setInfrastructureIssue(true);
            evidence.add("CPU usage exceeded 90%");
        }

        if(applicationErrors > 10){
            response.setApplicationIssue(true);
            evidence.add("Application error count exceeded threshold");
        }

        if(databaseConnections > 90){
            response.setDatabaseIssue(true);
            evidence.add("Database connection pool utilization exceeded 90%");
        }

        if(networkLatency > 100){
            response.setNetworkIssue(true);
            evidence.add("Network latency exceeded threshold");
        }

        if(response.isDatabaseIssue()){
            response.setRootCause("DATABASE BOTTLENECK");
            response.setSeverity("CRITICAL");
        } else if(response.isInfrastructureIssue()){
            response.setRootCause("HIGH CPU UTILIZATION");
            response.setSeverity("HIGH");
        } else if(response.isApplicationIssue()){
            response.setRootCause("APPLICATION FAILURE");
            response.setSeverity("MEDIUM");
        } else if(response.isNetworkIssue()){
            response.setRootCause("NETWORK LATENCY");
            response.setSeverity("MEDIUM");
        } else {
            response.setRootCause("NO ISSUES DETECTED");
            response.setSeverity("LOW");
        }

        response.setEvidence(evidence);

        return response;
    }
}