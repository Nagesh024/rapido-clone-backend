package com.rapido.search.dto;

public class HealthResponse {

    private String elasticsearch;
    private String kafka;
    private String redis;
    private String status;

    public String getElasticsearch() {
        return elasticsearch;
    }

    public void setElasticsearch(String elasticsearch) {
        this.elasticsearch = elasticsearch;
    }

    public String getKafka() {
        return kafka;
    }

    public void setKafka(String kafka) {
        this.kafka = kafka;
    }

    public String getRedis() {
        return redis;
    }

    public void setRedis(String redis) {
        this.redis = redis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}