package com.rapido.platformservice.dto;

public class NocDashboardResponse {

    private String clusterStatus;
    private String apiGatewayStatus;
    private String databaseStatus;
    private String redisStatus;
    private String kafkaStatus;

    private double cpuUsage;
    private double memoryUsage;
    private double diskUsage;

    private double apiLatency;

    private double uptime;

    private String timestamp;

    public NocDashboardResponse() {
    }

    public String getClusterStatus() {
        return clusterStatus;
    }

    public void setClusterStatus(String clusterStatus) {
        this.clusterStatus = clusterStatus;
    }

    public String getApiGatewayStatus() {
        return apiGatewayStatus;
    }

    public void setApiGatewayStatus(String apiGatewayStatus) {
        this.apiGatewayStatus = apiGatewayStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getRedisStatus() {
        return redisStatus;
    }

    public void setRedisStatus(String redisStatus) {
        this.redisStatus = redisStatus;
    }

    public String getKafkaStatus() {
        return kafkaStatus;
    }

    public void setKafkaStatus(String kafkaStatus) {
        this.kafkaStatus = kafkaStatus;
    }

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

    public double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(double diskUsage) {
        this.diskUsage = diskUsage;
    }

    public double getApiLatency() {
        return apiLatency;
    }

    public void setApiLatency(double apiLatency) {
        this.apiLatency = apiLatency;
    }

    public double getUptime() {
        return uptime;
    }

    public void setUptime(double uptime) {
        this.uptime = uptime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}