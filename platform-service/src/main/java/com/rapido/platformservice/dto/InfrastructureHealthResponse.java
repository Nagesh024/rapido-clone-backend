package com.rapido.platformservice.dto;

public class InfrastructureHealthResponse {

    private double cpuUsage;
    private double memoryUsage;
    private double availability;
    private double latency;
    private double errorRate;
    private double diskUsage;

    private int infrastructureHealthScore;

    private String status;

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public double getAvailability() {
        return availability;
    }

    public void setAvailability(double availability) {
        this.availability = availability;
    }

    public double getLatency() {
        return latency;
    }

    public void setLatency(double latency) {
        this.latency = latency;
    }

    public double getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(double errorRate) {
        this.errorRate = errorRate;
    }

    public double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(double diskUsage) {
        this.diskUsage = diskUsage;
    }

    public int getInfrastructureHealthScore() {
        return infrastructureHealthScore;
    }

    public void setInfrastructureHealthScore(int infrastructureHealthScore) {
        this.infrastructureHealthScore = infrastructureHealthScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}