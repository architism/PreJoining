package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Bike;
import java.util.Scanner;

/**
 * This class contains the main method and takes user input for parameterized
 * constructors.
 */

public class VehicleApp {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Using Parameterized Constructors ");

		System.out.print("--- Enter Car Details --- ");
		System.out.println();
		System.out.print("Enter brand : ");
		String brand = sc.nextLine();
		System.out.print("Enter model : ");
		String model = sc.nextLine();
		System.out.print("Enter rental price per day : ");
		double rentalPricePerDay = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter number of doors : ");
		int numberOfDoors = sc.nextInt();
		sc.nextLine();
		System.out.print("Is it automatic (true/false)? : ");
		boolean isAutomatic = sc.nextBoolean();
		sc.nextLine();

		Car car = new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);

		System.out.println("--- Displaying Car Details --- ");
		System.out.println();
		car.displayDetails();

		System.out.println();
		System.out.print("--- Enter Bike Details --- ");
		System.out.println();
		System.out.print("Enter brand : ");
		brand = sc.nextLine();
		System.out.print("Enter model : ");
		model = sc.nextLine();
		System.out.print("Enter rental price per day : ");
		rentalPricePerDay = sc.nextDouble();
		sc.nextLine();
		System.out.print("Does it have gears (true/false)? : ");
		boolean hasGear = sc.nextBoolean();
		sc.nextLine();
		System.out.print("Enter engine capacity (cc) : ");
		int engineCapacity = sc.nextInt();
		sc.nextLine();

		Bike bike = new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity);

		System.out.println();
		System.out.println("--- Displaying Bike Details --- ");
		bike.displayDetails();

		System.out.println();
		System.out.println("Using Default Constructors ");

		Car car1 = new Car();
		car1.inputDetails();
		System.out.println();

		System.out.println("--- Displaying Car Details --- ");
		car1.displayDetails();
		System.out.println();

		Bike bike1 = new Bike();
		bike1.inputDetails();
		System.out.println();

		System.out.println("--- Displaying Car Details --- ");
		bike1.displayDetails();
	}
}
