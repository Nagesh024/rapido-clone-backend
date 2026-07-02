package com.rapido.platformservice.dto;

public class SocDashboardResponse {

    private int failedLogins;
    private int oauthAttacks;
    private int bruteForceAttempts;
    private int suspiciousPayments;
    private int fraudAlerts;
    private int blockedIps;
    private int tokenAbuse;

    private String securityStatus;
    private String timestamp;

    public int getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(int failedLogins) {
        this.failedLogins = failedLogins;
    }

    public int getOauthAttacks() {
        return oauthAttacks;
    }

    public void setOauthAttacks(int oauthAttacks) {
        this.oauthAttacks = oauthAttacks;
    }

    public int getBruteForceAttempts() {
        return bruteForceAttempts;
    }

    public void setBruteForceAttempts(int bruteForceAttempts) {
        this.bruteForceAttempts = bruteForceAttempts;
    }

    public int getSuspiciousPayments() {
        return suspiciousPayments;
    }

    public void setSuspiciousPayments(int suspiciousPayments) {
        this.suspiciousPayments = suspiciousPayments;
    }

    public int getFraudAlerts() {
        return fraudAlerts;
    }

    public void setFraudAlerts(int fraudAlerts) {
        this.fraudAlerts = fraudAlerts;
    }

    public int getBlockedIps() {
        return blockedIps;
    }

    public void setBlockedIps(int blockedIps) {
        this.blockedIps = blockedIps;
    }

    public int getTokenAbuse() {
        return tokenAbuse;
    }

    public void setTokenAbuse(int tokenAbuse) {
        this.tokenAbuse = tokenAbuse;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}