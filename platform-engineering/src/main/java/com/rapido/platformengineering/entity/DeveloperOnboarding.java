package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "developer_onboarding")
public class DeveloperOnboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String developerName;

    private String email;

    private String roleName;

    private Boolean accessGranted;

    private String environmentName;

    private String status;

    public DeveloperOnboarding() {
    }

    public Long getId() {
        return id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleName() {
        return roleName;
    }

    public Boolean getAccessGranted() {
        return accessGranted;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setAccessGranted(Boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}