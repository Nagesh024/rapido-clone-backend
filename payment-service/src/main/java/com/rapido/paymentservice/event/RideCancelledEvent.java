package com.rapido.paymentservice.event;

public class RideCancelledEvent {

    private String rideId;
    private String status = "CANCELLED";

    public RideCancelledEvent() {}

    public RideCancelledEvent(String rideId) {
        this.rideId = rideId;
    }

	public String getRideId() {
		return rideId;
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // getters & setters
}