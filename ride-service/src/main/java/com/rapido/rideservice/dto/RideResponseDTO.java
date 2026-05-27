package com.rapido.rideservice.dto;

import com.rapido.rideservice.entity.RideStatus;

public class RideResponseDTO {

    private Long rideId;

    private Long userId;

    private Long driverId;

    private RideStatus status;

    private Double estimatedDistance;

    private Double estimatedFare;

    private String message;

    private Double surgeMultiplier;

    private Double estimatedEtaMinutes;

    private Double driverScore;

    public RideResponseDTO() {
    }
    public RideResponseDTO(
            Long rideId,
            Long userId,
            Long driverId,
            RideStatus status,
            Double estimatedDistance,
            Double estimatedFare,
            String message
    ) {
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.status = status;
        this.estimatedDistance = estimatedDistance;
        this.estimatedFare = estimatedFare;
        this.message = message;
    }
    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public Double getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(Double estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
    }

    public Double getEstimatedFare() {
        return estimatedFare;
    }

    public void setEstimatedFare(Double estimatedFare) {
        this.estimatedFare = estimatedFare;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(Double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    public Double getEstimatedEtaMinutes() {
        return estimatedEtaMinutes;
    }

    public void setEstimatedEtaMinutes(Double estimatedEtaMinutes) {
        this.estimatedEtaMinutes = estimatedEtaMinutes;
    }

    public Double getDriverScore() {
        return driverScore;
    }

    public void setDriverScore(Double driverScore) {
        this.driverScore = driverScore;
    }
}