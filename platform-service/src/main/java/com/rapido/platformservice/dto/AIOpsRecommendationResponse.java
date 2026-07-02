package com.rapido.platformservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AIOpsRecommendationResponse {

    private boolean scaleKubernetes;
    private boolean restartPods;
    private boolean increaseKafkaPartitions;
    private boolean increaseRedisMemory;
    private boolean optimizeDatabase;

    private List<String> recommendations;

    private String aiOpsStatus;

    private String timestamp;

    public AIOpsRecommendationResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public boolean isScaleKubernetes() {
        return scaleKubernetes;
    }

    public void setScaleKubernetes(boolean scaleKubernetes) {
        this.scaleKubernetes = scaleKubernetes;
    }

    public boolean isRestartPods() {
        return restartPods;
    }

    public void setRestartPods(boolean restartPods) {
        this.restartPods = restartPods;
    }

    public boolean isIncreaseKafkaPartitions() {
        return increaseKafkaPartitions;
    }

    public void setIncreaseKafkaPartitions(boolean increaseKafkaPartitions) {
        this.increaseKafkaPartitions = increaseKafkaPartitions;
    }

    public boolean isIncreaseRedisMemory() {
        return increaseRedisMemory;
    }

    public void setIncreaseRedisMemory(boolean increaseRedisMemory) {
        this.increaseRedisMemory = increaseRedisMemory;
    }

    public boolean isOptimizeDatabase() {
        return optimizeDatabase;
    }

    public void setOptimizeDatabase(boolean optimizeDatabase) {
        this.optimizeDatabase = optimizeDatabase;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    public String getAiOpsStatus() {
        return aiOpsStatus;
    }

    public void setAiOpsStatus(String aiOpsStatus) {
        this.aiOpsStatus = aiOpsStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}