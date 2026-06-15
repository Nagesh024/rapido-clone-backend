package com.rapido.adminservice.driverperformance;

public class DriverSuspensionResponse {

    private Long driverId;
    private String status;
    private String message;

    public DriverSuspensionResponse(Long driverId, String status, String message) {
        this.driverId = driverId;
        this.status = status;
        this.message = message;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}