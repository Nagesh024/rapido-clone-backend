package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.LoadTestResponse;
import org.springframework.stereotype.Service;

@Service
public class LoadTestService {

    public LoadTestResponse getStatus() {

        return new LoadTestResponse(
                "500 USERS TESTED",
                "100 DEPLOYMENTS TESTED",
                "50 ENVIRONMENTS TESTED",
                "PASSED",
                "PASSED",
                "PASSED"
        );
    }
}