package com.litmus7.vehiclerentalsystem;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * This class contains main method and method to display the list.
 */
public class VehicleApp {
	public static void main(String args[]) {
		VehicleService service = new VehicleService();
		List<Vehicle> vehicles;

		System.out.println("Loading vehicles from file.");
		vehicles = service.loadVehiclesFromFile("vehicles.txt");

		System.out.println("Displaying all loaded vehicles.");
		System.out.println();

		VehicleApp.displayVehicles(vehicles);

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

					vehicles = service.addVehicle(vehicles,
							new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));
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

					vehicles = service.addVehicle(vehicles,
							new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));
				}
			}

			System.out.println();
			System.out.println("Updated vehicle list.");
			System.out.println();
			VehicleApp.displayVehicles(vehicles);
		}

		System.out.println();

		System.out.println("Do you want to search for a brand?(yes/no) : ");
		choice = sc.nextLine();
		if (choice.equalsIgnoreCase("yes")) {

			System.out.println("Enter brand to be searched : ");
			String brand = sc.nextLine();
			System.out.println();
			service.searchBrand(vehicles, brand);
		}
		System.out.println();
		System.out.println("Do you want to calculate total rent?(yes/no) : ");
		choice = sc.nextLine();
		System.out.println();
		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter number of days to calculate total rent : ");
			int dayCount = sc.nextInt();
			sc.nextLine();
			System.out.println();
			service.totalRentalPrice(vehicles, dayCount);
		}
	}

	/**
	 * This method displays the contents of the list.
	 * 
	 * @param vehicles which is a Vehicle list
	 */

	public static void displayVehicles(List<Vehicle> vehicles) {

		for (Vehicle vehicle : vehicles) {
			vehicle.displayDetails();
			System.out.println();
		}
	}

}
