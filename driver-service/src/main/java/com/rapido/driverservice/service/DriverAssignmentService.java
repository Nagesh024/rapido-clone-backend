package com.rapido.driverservice.service;

public class DriverAssignmentService {
	public class RideAssignedEvent {

	    private String rideId;
	    private String driverId;
	    private String status = "ASSIGNED";
		public String getRideId() {
			return rideId;
		}
		public void setRideId(String rideId) {
			this.rideId = rideId;
		}
		public String getDriverId() {
			return driverId;
		}
		public void setDriverId(String driverId) {
			this.driverId = driverId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

	    // constructors, getters, setters
	}
}
