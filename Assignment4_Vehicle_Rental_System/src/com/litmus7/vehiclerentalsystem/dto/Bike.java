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
	 * @param brand which is a string
	 * @param model which is a string
	 * @param rentalPricePerDay which is a double
	 * @param hasGear which is a boolean
	 * @param engineCapacity which is an integer
	 */

	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {

		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;

	}

	/**
	 * This method calls input method of parent class and takes input whether bike
	 * has gear or not and its engine capacity.
	 */

	public void inputDetails() {

		System.out.println(" --- Enter Bike Details ---");
		super.inputDetails();
		Scanner sc = new Scanner(System.in);
		System.out.print("Does it have gears (true/false)? : ");
		hasGear = sc.nextBoolean();
		sc.nextLine();
		System.out.print("Enter engine capacity (cc) : ");
		engineCapacity = sc.nextInt();
		sc.nextLine();
	}

	/**
	 * This method displays the data of bike object.
	 */

	public void displayDetails() {

		super.displayDetails();
		System.out.println("Has Gear : " + hasGear);
		System.out.println("Engine Capacity : " + engineCapacity + " cc");
	}

}
