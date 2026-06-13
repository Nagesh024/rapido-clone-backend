package com.rapido.globalservice.compliance;

import jakarta.persistence.*;

@Entity
@Table(
        name = "compliance_configurations",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_country_compliance",
                        columnNames = "country_code"
                )
        }
)
public class ComplianceConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "country_code",
            nullable = false,
            length = 10
    )
    private String countryCode;

    @Column(
            name = "data_retention_days",
            nullable = false
    )
    private Integer dataRetentionDays;

    @Column(
            name = "privacy_policy_version",
            nullable = false
    )
    private String privacyPolicyVersion;

    @Column(
            name = "document_requirement",
            nullable = false
    )
    private String documentRequirement;

    @Column(
            name = "ride_history_retention_days",
            nullable = false
    )
    private Integer rideHistoryRetentionDays;

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getDataRetentionDays() {
        return dataRetentionDays;
    }

    public void setDataRetentionDays(Integer dataRetentionDays) {
        this.dataRetentionDays = dataRetentionDays;
    }

    public String getPrivacyPolicyVersion() {
        return privacyPolicyVersion;
    }

    public void setPrivacyPolicyVersion(String privacyPolicyVersion) {
        this.privacyPolicyVersion = privacyPolicyVersion;
    }

    public String getDocumentRequirement() {
        return documentRequirement;
    }

    public void setDocumentRequirement(String documentRequirement) {
        this.documentRequirement = documentRequirement;
    }

    public Integer getRideHistoryRetentionDays() {
        return rideHistoryRetentionDays;
    }

    public void setRideHistoryRetentionDays(Integer rideHistoryRetentionDays) {
        this.rideHistoryRetentionDays = rideHistoryRetentionDays;
    }
}