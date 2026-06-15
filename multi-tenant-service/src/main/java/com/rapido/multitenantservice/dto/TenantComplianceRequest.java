package com.rapido.multitenantservice.dto;

public class TenantComplianceRequest {

    private String complianceType;
    private String complianceStatus;
    private String remarks;

    public String getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}