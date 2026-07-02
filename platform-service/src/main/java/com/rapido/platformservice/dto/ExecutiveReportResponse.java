package com.rapido.platformservice.dto;

public class ExecutiveReportResponse {

    private String dailyOperationsReport;

    private String weeklyExecutiveReport;

    private String monthlyBusinessReview;

    private String pdfStatus;

    private String excelStatus;

    private String reportStatus;

    public String getDailyOperationsReport() {
        return dailyOperationsReport;
    }

    public void setDailyOperationsReport(String dailyOperationsReport) {
        this.dailyOperationsReport = dailyOperationsReport;
    }

    public String getWeeklyExecutiveReport() {
        return weeklyExecutiveReport;
    }

    public void setWeeklyExecutiveReport(String weeklyExecutiveReport) {
        this.weeklyExecutiveReport = weeklyExecutiveReport;
    }

    public String getMonthlyBusinessReview() {
        return monthlyBusinessReview;
    }

    public void setMonthlyBusinessReview(String monthlyBusinessReview) {
        this.monthlyBusinessReview = monthlyBusinessReview;
    }

    public String getPdfStatus() {
        return pdfStatus;
    }

    public void setPdfStatus(String pdfStatus) {
        this.pdfStatus = pdfStatus;
    }

    public String getExcelStatus() {
        return excelStatus;
    }

    public void setExcelStatus(String excelStatus) {
        this.excelStatus = excelStatus;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
}