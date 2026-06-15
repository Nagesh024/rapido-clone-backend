package com.rapido.multitenantservice.kafka;

public class TenantEvent {

    private String tenantId;
    private String eventType;
    private String payload;

    public TenantEvent() {
    }

    public TenantEvent(
            String tenantId,
            String eventType,
            String payload) {

        this.tenantId = tenantId;
        this.eventType = eventType;
        this.payload = payload;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}