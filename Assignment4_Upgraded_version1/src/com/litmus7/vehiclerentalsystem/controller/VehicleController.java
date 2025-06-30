package com.litmus7.vehiclerentalsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * This class validates requests to perform loading vehicles from file, adding
 * new vehicles, searching for vehicles and calculating total rent and also
 * provides appropriate responses.
 */

public class VehicleController {

	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int ERROR_STATUS_CODE = 400;

	VehicleService vehicleService = new VehicleService();

	public Response loadVehiclesFromFile(String filePath) {

		Response response = new Response();
		List<Vehicle> vehicles = null;

		if (filePath == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Entered filepath is invalid");
			return response;
		}

		try {
			vehicles = vehicleService.loadVehiclesFromFile(filePath);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);

		} catch (VehicleServiceException e) {

			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load vehicle data");

		}

		return response;

	}

	public Response addVehicle(List<Vehicle> vehicles, Vehicle vehicle) {
		Response response = new Response();
		List<Vehicle> vehicles1 = null;

		if (vehicles == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot add vehicle as list is empty");
			return response;
		}

		else if ((vehicle.getBrand() == "") || (vehicle.getModel() == "") || (vehicle.getRentalPricePerDay() == 0.0)) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot add the entered car");
			return response;
		}

		try {
			vehicles1 = vehicleService.addVehicle(vehicles, vehicle);
			response.setVehicles(vehicles1);
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {

			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());

		}
		return response;

	}

	public Response searchVehicle(List<Vehicle> vehicles, String brand, String model) {

		Response response = new Response();

		if (vehicles == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot search as list is empty");
			return response;
		}

		else if (brand == "" || brand == null || model == "" || model == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot search as vehicle name is empty");
			return response;
		}

		try {
			Vehicle vehicle = vehicleService.searchVehicle(vehicles, brand, model);
			response.setVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);

		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());

		}
		return response;
	}

	public Response totalRentalPrice(List<Vehicle> vehicles, int dayCount) {

		Response response = new Response();
		if (vehicles == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot calculate rent for empty list of vehicles");
			return response;
		}

		else if (dayCount == 0) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Cannot calculate rent for zero days");
			return response;
		}

		List<String> totalRentalPrice = vehicleService.totalRentalPrice(vehicles, dayCount);
		response.setTotalRentalPrice(totalRentalPrice);
		response.setStatusCode(SUCCESS_STATUS_CODE);
		return response;

	}

}
