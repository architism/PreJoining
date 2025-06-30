package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * This class contains data of bike object which inherits from vehicle.
 */

public class Bike extends Vehicle {

	private boolean hasGear;
	private int engineCapacity;

	/**
	 * This is a default constructor which initializes whether bike has gear or not
	 * and engine capacity.
	 */

	public Bike() {

		super();
		hasGear = false;
		engineCapacity = 125;

	}

	/**
	 * This is a parameterized constructor.
	 * 
	 * @param brand             which is a string
	 * @param model             which is a string
	 * @param rentalPricePerDay which is a double
	 * @param hasGear           which is a boolean
	 * @param engineCapacity    which is an integer
	 */

	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {

		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;

	}

	/**
	 * This method displays the data of bike object.
	 */

	@Override
	public String toString() {
		return "Bike [brand = " + getBrand() + ", model = " + getModel() + ", rentalPricePerDay = " + getRentalPricePerDay()
				+ ", hasGear = " + hasGear + ", engineCapacity = " + engineCapacity + "]";
	}

}
