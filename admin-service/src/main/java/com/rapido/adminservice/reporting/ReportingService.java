package com.rapido.adminservice.reporting;

import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    public ReportResponse generateRevenueReport(String format) {

        return new ReportResponse(
                "Revenue Report",
                format,
                "Generated Successfully"
        );
    }

    public ReportResponse generateRideReport(String format) {

        return new ReportResponse(
                "Ride Report",
                format,
                "Generated Successfully"
        );
    }

    public ReportResponse generateFraudReport(String format) {

        return new ReportResponse(
                "Fraud Report",
                format,
                "Generated Successfully"
        );
    }
}