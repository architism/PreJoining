package com.litmus7.vehiclerentalsystem.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.dto.Bike;

/**
 * Class which provides services such as loading vehicles from file, adding new
 * vehicles,searching for a brand and calculating total rent for vehicles.
 */

public class VehicleService {

	/**
	 * This method loads vehicles from a file to a list.
	 * 
	 * @param filePath which is a String
	 * @return list of vehicles
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) {

		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equalsIgnoreCase("Car")) {

					String brand = parts[1];
					String model = parts[2];
					double rentalPricePerDay = Double.parseDouble(parts[3]);
					int numberOfDoors = Integer.parseInt(parts[4]);
					boolean isAutomatic = Boolean.parseBoolean(parts[5]);

					vehicles.add(new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));
				}

				else {

					String brand = parts[1];
					String model = parts[2];
					double rentalPricePerDay = Double.valueOf(parts[3]);
					Boolean hasGear = Boolean.parseBoolean(parts[4]);
					int engineCapacity = Integer.parseInt(parts[5]);

					vehicles.add(new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));

				}

			}
			reader.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicles;

	}

	/**
	 * This method adds a new car to the list.
	 * 
	 * @param vehicles which is a Vehicle list
	 * @param car      which is a Car object
	 * @return list of vehicles
	 */
	public List<Vehicle> addVehicle(List<Vehicle> vehicles, Car car) {
		vehicles.add(car);
		return vehicles;

	}

	/**
	 * This method adds a new bike to the list.
	 * 
	 * @param vehicles which is a Vehicle list
	 * @param bike     which is a Bike object
	 * @return list of vehicles
	 */

	public List<Vehicle> addVehicle(List<Vehicle> vehicles, Bike bike) {
		vehicles.add(bike);
		return vehicles;
	}

	/**
	 * This method searches for a brand.
	 * 
	 * @param vehicles which is a list of vehicles
	 * @param brand    which is a String
	 */

	public void searchBrand(List<Vehicle> vehicles, String brand) {

		System.out.println("Searching for brand " + brand);
		int flag = 0;

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getBrand().equalsIgnoreCase(brand)) {
				System.out.println();
				vehicle.displayDetails();
				flag = 1;

			}

		}
		if (flag == 0)
			System.out.println(brand + " Brand is not found");

	}

	/**
	 * This method calculates total rent for vehicles.
	 * 
	 * @param vehicles which is a Vehicle list
	 * @param dayCount which is an integer
	 */
	public void totalRentalPrice(List<Vehicle> vehicles, int dayCount) {

		System.out.println("Total rent for " + dayCount + " days : ");
		System.out.println();
		for (Vehicle vehicle : vehicles) {
			System.out.println(
					vehicle.getBrand() + " " + vehicle.getModel() + " = " + vehicle.getRentalPricePerDay() * dayCount);
		}

	}

}
