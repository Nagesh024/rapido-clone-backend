package com.rapido.platformservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class OperationsResponse {

    private String status;
    private String timestamp;
    private Map<String, Object> data;

    public OperationsResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}