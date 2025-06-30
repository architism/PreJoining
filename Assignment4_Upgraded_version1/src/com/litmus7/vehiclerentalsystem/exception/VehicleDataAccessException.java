package com.litmus7.vehiclerentalsystem.exception;

/**
 * This class defines exception thrown during loading vehicles from the file.
 */
public class VehicleDataAccessException extends Exception {

	public VehicleDataAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VehicleDataAccessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VehicleDataAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VehicleDataAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
