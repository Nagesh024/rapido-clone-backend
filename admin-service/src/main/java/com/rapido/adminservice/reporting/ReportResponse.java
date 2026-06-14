package com.rapido.adminservice.reporting;

public class ReportResponse {

    private String reportType;
    private String format;
    private String status;

    public ReportResponse(String reportType,
                          String format,
                          String status) {
        this.reportType = reportType;
        this.format = format;
        this.status = status;
    }

    public String getReportType() {
        return reportType;
    }

    public String getFormat() {
        return format;
    }

    public String getStatus() {
        return status;
    }
}