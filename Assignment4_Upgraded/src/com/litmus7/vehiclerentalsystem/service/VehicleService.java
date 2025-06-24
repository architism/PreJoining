package com.litmus7.vehiclerentalsystem.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Bike;

/**
 * Class which provides services such as loading vehicles from file, adding new
 * vehicles, displaying vehicle details, searching for a brand and calculating
 * total rent for vehicles.
 */

public class VehicleService {

	List<Car> cars = new ArrayList<Car>();
	List<Bike> bikes = new ArrayList<Bike>();

	/**
	 * This method loads vehicles from a file to a list.
	 * 
	 * @param filePath path of the file which is a string.
	 */
	public void loadVehiclesFromFile(String filePath) {

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

					cars.add(new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));
				}

				else {

					String brand = parts[1];
					String model = parts[2];
					double rentalPricePerDay = Double.valueOf(parts[3]);
					Boolean hasGear = Boolean.parseBoolean(parts[4]);
					int engineCapacity = Integer.parseInt(parts[5]);

					bikes.add(new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));

				}

			}
			reader.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method adds a new car to the list.
	 * 
	 * @param car which is a Car object.
	 */
	public void addVehicle(Car car) {
		cars.add(car);

	}

	/**
	 * This method adds a new bike to the list.
	 * 
	 * @param bike which is a Bike object.
	 */

	public void addVehicle(Bike bike) {
		bikes.add(bike);
	}

	/**
	 * This method prints vehicle details.
	 */
	public void printVehicles() {

		System.out.println("--- Cars ---");

		for (Car car : cars) {
			car.displayDetails();
			System.out.println();
		}
		System.out.println("--- Bikes ---");
		for (Bike bike : bikes) {
			bike.displayDetails();
			System.out.println();
		}

	}

	/**
	 * This method searches for a brand.
	 * 
	 * @param brand which is a String.
	 */

	public void searchBrand(String brand) {

		System.out.println("Searching for brand " + brand);
		int flag = 0;

		for (Car car : cars) {
			if (car.getBrand().equalsIgnoreCase(brand)) {
				System.out.println();
				car.displayDetails();
				flag = 1;

			}
		}

		for (Bike bike : bikes) {
			if (bike.getBrand().equalsIgnoreCase(brand)) {
				System.out.println();
				bike.displayDetails();
				flag = 1;

			}
		}
		if (flag == 0)
			System.out.println(brand + " Brand is not found");

	}

	/**
	 * This method calculates total rent for all vehicles.
	 * 
	 * @param dayCount which is an integer.
	 */
	public void totalRentalPrice(int dayCount) {

		System.out.println("Total rent for " + dayCount + " days : ");
		System.out.println();
		for (Car car : cars) {
			System.out.println(car.getBrand() + " " + car.getModel() + " = " + car.getRentalPricePerDay() * dayCount);
		}

		for (Bike bike : bikes) {
			System.out
					.println(bike.getBrand() + " " + bike.getModel() + " = " + bike.getRentalPricePerDay() * dayCount);
		}
	}

}
