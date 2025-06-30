package com.litmus7.vehiclerentalsystem.dto;

import java.util.Objects;

/**
 * This class contains data of vehicle.
 */

public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * This is a default constructor which initializes brand, model and rent per day
	 * of vehicle.
	 */
	public Vehicle() {

		brand = "";
		model = "";
		rentalPricePerDay = 0.0;
	}

	/**
	 * This is a parameterized constructor.
	 * 
	 * @param brand             which is a string
	 * @param model             which is a string
	 * @param rentalPricePerDay which is a double
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {

		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model);
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay + "]";
	}

}