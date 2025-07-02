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
		Response<List<Vehicle>> loadVehicleFromFileResponse = vehicleController.loadVehiclesFromFile("vehicles.txt");

		if (loadVehicleFromFileResponse.getStatusCode() == 200) {
			System.out.println("Vehicles loaded successfully");
			System.out.println("Displaying all loaded vehicles.");
			vehicles = loadVehicleFromFileResponse.getResponseItem();
			VehicleApp.displayVehicles(vehicles);
		} else {
			System.out.println(loadVehicleFromFileResponse.getErrorMessage());
		}

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Do you want to enter more vehicles?(yes/no) : ");
			String choice = sc.nextLine();

			if (choice.equalsIgnoreCase("yes")) {
				
				Response<List<Vehicle>> addVehicleResponse;
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

						addVehicleResponse = vehicleController.addVehicle(vehicles,
								new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));

						if (addVehicleResponse.getStatusCode() == 200) {
							System.out.println("Vehicle added successfully");
							vehicles = addVehicleResponse.getResponseItem();
							System.out.println("Updated vehicle list");
							VehicleApp.displayVehicles(vehicles);
						} else {
							System.out.println();
							System.out.println(addVehicleResponse.getErrorMessage());
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

						addVehicleResponse = vehicleController.addVehicle(vehicles,
								new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));

						if (addVehicleResponse.getStatusCode() == 200) {
							System.out.println("Vehicle added successfully");
							vehicles = addVehicleResponse.getResponseItem();
							System.out.println("Updated vehicle list");
							VehicleApp.displayVehicles(vehicles);
						} else {
							System.out.println(addVehicleResponse.getErrorMessage());
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
				
				Response<Vehicle> searchVehicleResponse;
				System.out.println("Enter brand to be searched : ");
				String brand = sc.nextLine();
				System.out.println("Enter model to be searched : ");
				String model = sc.nextLine();
				System.out.println();
				searchVehicleResponse = vehicleController.searchVehicle(vehicles, brand, model);

				if (searchVehicleResponse.getStatusCode() == 200) {
					System.out.println("Vehicle has been found");
					Vehicle vehicle = searchVehicleResponse.getResponseItem();
					System.out.println(vehicle);

				} else {
					System.out.println(searchVehicleResponse.getErrorMessage());
				}

			}
			System.out.println();
			System.out.println("Do you want to calculate total rent?(yes/no) : ");
			choice = sc.nextLine();
			System.out.println();
			if (choice.equalsIgnoreCase("yes")) {
				
				Response<List<String>> getTotalRentResponse;
				System.out.println("Enter number of days to calculate total rent : ");
				int dayCount = sc.nextInt();
				sc.nextLine();
				System.out.println();

				getTotalRentResponse = vehicleController.totalRentalPrice(vehicles, dayCount);
				if (getTotalRentResponse.getStatusCode() == 200) {
					System.out.println("Total rent for " + dayCount + " days: ");
					System.out.println(getTotalRentResponse.getResponseItem());

				} else {
					System.out.println(getTotalRentResponse.getErrorMessage());
				}
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
