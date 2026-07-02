package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.ExecutiveReportResponse;
import org.springframework.stereotype.Service;

@Service
public class ExecutiveReportService {

    public ExecutiveReportResponse generateReports() {

        ExecutiveReportResponse response =
                new ExecutiveReportResponse();

        response.setDailyOperationsReport("GENERATED");

        response.setWeeklyExecutiveReport("GENERATED");

        response.setMonthlyBusinessReview("GENERATED");

        response.setPdfStatus("READY");

        response.setExcelStatus("READY");

        response.setReportStatus("SUCCESS");

        return response;
    }

}