package com.litmus7.vehiclerentalsystem.dto;

/**
 * This class defines responses returned by the VehicleController.
 */

public class Response<T> {

	private String errorMessage;
	private int statusCode;
	private T responseItem;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public T getResponseItem() {
		return responseItem;
	}

	public void setResponseItem(T responseItem) {
		this.responseItem = responseItem;
	}

}
