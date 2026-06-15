package com.rapido.search.events;

public class DriverStatusEvent {

    private String driverId;
    private String status;
    private double latitude;
    private double longitude;
    private long timestamp;

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}