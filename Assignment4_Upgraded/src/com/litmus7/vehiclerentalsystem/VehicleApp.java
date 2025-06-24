package com.litmus7.vehiclerentalsystem;

import java.util.Scanner;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * This class contains main method which can add new vehicles, search for brands
 * and find total rent.
 */
public class VehicleApp {
	public static void main(String args[]) {
		VehicleService service = new VehicleService();

		System.out.println("Loading vehicles from file.");
		service.loadVehiclesFromFile("vehicles.txt");

		System.out.println("Displaying all loaded vehicles.");
		System.out.println();
		service.printVehicles();
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to enter more vehicles?(yes/no) : ");
		String choice = sc.nextLine();

		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter number of vehicles  to be entered : ");

			int count = sc.nextInt();
			sc.nextLine();

			for (int i = 1; i <= count; i++) {
				System.out.println();
				System.out.println("Enter type of vehicle : ");
				String type = sc.nextLine();

				if (type.equalsIgnoreCase("Car")) {
					System.out.println();
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

					service.addVehicle(new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));
				}

				else if (type.equalsIgnoreCase("Bike")) {

					System.out.println();
					System.out.print("--- Enter Bike Details --- ");
					System.out.println();
					System.out.print("Enter brand : ");
					String brand = sc.nextLine();
					System.out.print("Enter model : ");
					String model = sc.nextLine();
					System.out.print("Enter rental price per day : ");
					double rentalPricePerDay = sc.nextDouble();
					sc.nextLine();
					System.out.print("Does it have gears (true/false)? : ");
					boolean hasGear = sc.nextBoolean();
					sc.nextLine();
					System.out.print("Enter engine capacity (cc) : ");
					int engineCapacity = sc.nextInt();
					sc.nextLine();

					service.addVehicle(new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));
				}
			}

			System.out.println();
			System.out.println("Updated vehicle list.");
			System.out.println();
			service.printVehicles();
		}

		System.out.println();
		System.out.println("Enter brand to be searched : ");
		String brand = sc.nextLine();
		System.out.println();
		service.searchBrand(brand);
		System.out.println();
		System.out.println("Enter number of days to calculate total rent : ");
		int dayCount = sc.nextInt();
		sc.nextLine();
		System.out.println();
		service.totalRentalPrice(dayCount);
	}

}
