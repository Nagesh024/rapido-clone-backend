package com.rapido.platformservice.dto;

import java.util.List;

public class CapacityDashboardResponse {

    private double currentLoad;
    private double maximumCapacity;

    private List<Double> cpuTrend;
    private List<Double> memoryTrend;
    private List<Double> storageGrowth;

    private long kafkaLag;

    private String capacityStatus;

    private String timestamp;

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

    public double getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public List<Double> getCpuTrend() {
        return cpuTrend;
    }

    public void setCpuTrend(List<Double> cpuTrend) {
        this.cpuTrend = cpuTrend;
    }

    public List<Double> getMemoryTrend() {
        return memoryTrend;
    }

    public void setMemoryTrend(List<Double> memoryTrend) {
        this.memoryTrend = memoryTrend;
    }

    public List<Double> getStorageGrowth() {
        return storageGrowth;
    }

    public void setStorageGrowth(List<Double> storageGrowth) {
        this.storageGrowth = storageGrowth;
    }

    public long getKafkaLag() {
        return kafkaLag;
    }

    public void setKafkaLag(long kafkaLag) {
        this.kafkaLag = kafkaLag;
    }

    public String getCapacityStatus() {
        return capacityStatus;
    }

    public void setCapacityStatus(String capacityStatus) {
        this.capacityStatus = capacityStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}