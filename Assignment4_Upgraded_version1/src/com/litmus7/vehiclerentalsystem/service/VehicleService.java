package com.litmus7.vehiclerentalsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;
import com.litmus7.vehiclerentalsystem.dao.VehicleFileDao;

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
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleServiceException {

		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		VehicleFileDao vehicleFileDao = new VehicleFileDao();

		try {
			vehicles = vehicleFileDao.loadVehiclesFromFile(filePath);

		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getMessage(), e);
		}
		return vehicles;

	}

	/**
	 * This method adds a new vehicle to the list.
	 * 
	 * @param vehicles which is a Vehicle list
	 * @param vehicle  which is a Vehicle object
	 * @return list of vehicles
	 * @throws VehicleServiceException
	 */
	public List<Vehicle> addVehicle(List<Vehicle> vehicles, Vehicle vehicle) throws VehicleServiceException {

		if (!vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
			return vehicles;
		}
		throw new VehicleServiceException("Cannot add as vehicle already exists");

	}

	/**
	 * 
	 * @param vehicles which is a list of vehicles
	 * @param brand    which is a String
	 * @param model    which is a String
	 * @return vehicle which is a Vehicle object
	 * @throws VehicleServiceException
	 */

	public Vehicle searchVehicle(List<Vehicle> vehicles, String brand, String model) throws VehicleServiceException {

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getBrand().equalsIgnoreCase(brand) && vehicle.getModel().equalsIgnoreCase(model)) {
				return vehicle;
			}
		}

		throw new VehicleServiceException("Vehicle not found");
	}

	/**
	 * This method calculates total rent for a vehicles for a specified day count.
	 * 
	 * @param vehicles which is a List
	 * @param dayCount which is an Integer
	 * @return totalRentalPrice which is a List
	 */
	public List<String> totalRentalPrice(List<Vehicle> vehicles, int dayCount) {

		List<String> totalRentalPrice = new ArrayList<String>();
		for (Vehicle vehicle : vehicles) {
			totalRentalPrice.add(
					vehicle.getBrand() + " " + vehicle.getModel() + " = " + vehicle.getRentalPricePerDay() * dayCount);

		}

		return totalRentalPrice;

	}
}
