package com.litmus7.vehiclerentalsystem.dto;

import java.util.List;

/**
 * This class defines responses returned by the VehicleController.
 */

public class Response {

	private String errorMessage;
	private int statusCode;
	private List<Vehicle> vehicles;
	private Vehicle vehicle;
	private List<String> totalRentalPrice;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<String> getTotalRentalPrice() {
		return totalRentalPrice;
	}

	public void setTotalRentalPrice(List<String> totalRentalPrice) {
		this.totalRentalPrice = totalRentalPrice;
	}

}
