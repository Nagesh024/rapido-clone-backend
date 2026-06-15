package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tenant_compliance")
public class TenantCompliance extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complianceType;

    private String complianceStatus;

    private String remarks;

    public Long getId() {
        return id;
    }

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