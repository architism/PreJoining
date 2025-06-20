package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

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
 *This is a parameterized constructor.
 * @param brand which is a string
 * @param model which is a string
 * @param rentalPricePerDay which is a double
 * @param numberOfDoors which is an integer
 * @param isAutomatic which is a boolean
 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * This method calls input method of parent class and also takes user input for
	 * number of doors and whether the car is automatic or not.
	 */

	public void inputDetails() {
		System.out.println(" --- Enter Car Details--- ");
		super.inputDetails();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of doors : ");
		numberOfDoors = sc.nextInt();
		sc.nextLine();
		System.out.print("Is it automatic (true/false)?  : ");
		isAutomatic = sc.nextBoolean();
		sc.nextLine();
	}

	/**
	 * This method displays the data of car object.
	 */

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors : " + numberOfDoors);
		System.out.println("Automatic : " + isAutomatic);
	}

}
