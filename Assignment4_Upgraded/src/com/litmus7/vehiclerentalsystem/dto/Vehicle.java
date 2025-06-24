package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

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

	/**
	 * This method takes user input for brand, model and rental price per day of
	 * vehicle.
	 */
	public void inputDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter brand : ");
		brand = sc.nextLine();
		System.out.print("Enter model : ");
		model = sc.nextLine();
		System.out.print("Enter rental price per day : ");
		rentalPricePerDay = sc.nextDouble();
		sc.nextLine();
	}

	/**
	 * This method displays data of vehicle object.
	 */

	public void displayDetails() {
		System.out.println("Brand : " + brand);
		System.out.println("Model : " + model);
		System.out.println("Rental Price/Day : " + rentalPricePerDay);
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

}