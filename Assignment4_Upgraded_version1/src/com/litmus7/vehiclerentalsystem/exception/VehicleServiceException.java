package com.litmus7.vehiclerentalsystem.exception;

/**
 * This class defines exception thrown when performing services of Vehicle
 * Rental System.
 */

public class VehicleServiceException extends Exception {

	public VehicleServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
