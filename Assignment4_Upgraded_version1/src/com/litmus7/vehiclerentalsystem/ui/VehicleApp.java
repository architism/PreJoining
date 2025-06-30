package com.litmus7.vehiclerentalsystem.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;

/**
 * This class contains main method and method to display the list of vehicles.
 */
public class VehicleApp {
	public static void main(String args[]) {
		VehicleController vehicleController = new VehicleController();
		List<Vehicle> vehicles = null;

		System.out.println("Loading vehicles from file.");
		Response response = vehicleController.loadVehiclesFromFile("vehicles.txt");

		if (response.getStatusCode() == 200) {
			System.out.println("Vehicles loaded successfully");
			System.out.println("Displaying all loaded vehicles.");
			vehicles = response.getVehicles();
			VehicleApp.displayVehicles(vehicles);
		} else {
			System.out.println(response.getErrorMessage());
		}

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

					response = vehicleController.addVehicle(vehicles,
							new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));

					if (response.getStatusCode() == 200) {
						System.out.println("Vehicle added successfully");
						vehicles = response.getVehicles();
						System.out.println("Updated vehicle list");
						VehicleApp.displayVehicles(vehicles);
					} else {
						System.out.println();
						System.out.println(response.getErrorMessage());
					}

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

					response = vehicleController.addVehicle(vehicles,
							new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));

					if (response.getStatusCode() == 200) {
						System.out.println("Vehicle added successfully");
						vehicles = response.getVehicles();
						System.out.println("Updated vehicle list");
						VehicleApp.displayVehicles(vehicles);
					} else {
						System.out.println(response.getErrorMessage());
					}
				}

				else {
					System.out.println("Invalid vehicle type");
				}
			}
		}

		System.out.println();

		System.out.println("Do you want to search for a vehicle?(yes/no) : ");
		choice = sc.nextLine();

		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter brand to be searched : ");
			String brand = sc.nextLine();
			System.out.println("Enter model to be searched : ");
			String model = sc.nextLine();
			System.out.println();
			response = vehicleController.searchVehicle(vehicles, brand, model);

			if (response.getStatusCode() == 200) {
				System.out.println("Vehicle has been found");
				Vehicle vehicle = response.getVehicle();
				System.out.println(vehicle);

			} else {
				System.out.println(response.getErrorMessage());
			}

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

			response = vehicleController.totalRentalPrice(vehicles, dayCount);
			if (response.getStatusCode() == 200) {
				System.out.println(response.getTotalRentalPrice());

			} else {
				System.out.println(response.getErrorMessage());
			}
		}
	}

	/**
	 * This method displays the contents of the list.
	 * 
	 * @param vehicles which is a Vehicle list
	 */

	public static void displayVehicles(List<Vehicle> vehicles) {

		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
			System.out.println();
		}
	}

}
