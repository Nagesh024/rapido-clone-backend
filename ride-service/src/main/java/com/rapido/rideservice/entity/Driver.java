package com.rapido.rideservice.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "drivers")

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getAcceptanceRate() {
		return acceptanceRate;
	}
	public void setAcceptanceRate(Double acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}
	public Double getCancellationRate() {
		return cancellationRate;
	}
	public void setCancellationRate(Double cancellationRate) {
		this.cancellationRate = cancellationRate;
	}
	public Integer getCurrentLoad() {
		return currentLoad;
	}
	public void setCurrentLoad(Integer currentLoad) {
		this.currentLoad = currentLoad;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	private String name;
    private String phoneNumber;
    private String vehicleNumber;

    private Boolean active;
    private Boolean available;

    private Double rating;
    private Double acceptanceRate;
    private Double cancellationRate;
    private Integer currentLoad;

    private Double latitude;
    private Double longitude;
}