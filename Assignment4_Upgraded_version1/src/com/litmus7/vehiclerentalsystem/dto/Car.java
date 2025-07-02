package com.litmus7.vehiclerentalsystem.dto;



/**
 * This class contains data of car object which inherits from vehicle.
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * This is a default constructor which initializes number of doors and whether
	 * car is automatic or not.
	 */

	public Car() {
		super();
		numberOfDoors = 4;
		isAutomatic = false;
	}

	/**
	 * This is a parameterized constructor.
	 * 
	 * @param brand             which is a string
	 * @param model             which is a string
	 * @param rentalPricePerDay which is a double
	 * @param numberOfDoors     which is an integer
	 * @param isAutomatic       which is a boolean
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	

	/**
	 * This method displays the data of car object.
	 */

	
	@Override
	public String toString() {
		return "Car [brand = " + getBrand() + ", model = " + getModel() + ", rentalPricePerDay = " + getRentalPricePerDay()
				+ ",  numberOfDoors = " + numberOfDoors + ", isAutomatic = " + isAutomatic + "]";
	}

	
}
