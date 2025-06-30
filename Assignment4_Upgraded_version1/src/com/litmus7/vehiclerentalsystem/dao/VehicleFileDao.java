package com.litmus7.vehiclerentalsystem.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;

/**
 * This class handles reading data from file.
 */

public class VehicleFileDao {

	/**
	 * This method reads vehicle data from text file.
	 * 
	 * @param filePath which is a String
	 * @return a list a vehicles
	 * @throws VehicleDataAccessException
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleDataAccessException {

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

		catch (FileNotFoundException e) {
			throw new VehicleDataAccessException("Requested file could not be found", e);
		}

		catch (IOException e) {
			throw new VehicleDataAccessException(e.getMessage());
		}
		return vehicles;

	}
}
