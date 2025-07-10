package com.litmus7.retailproductmanagement.dto;

public class Response<T> {

	private int statusCode;
	private String responseMessage;
	private T responseItem;

	public Response(int status_code, String responseMessage, T responseItem) {
		super();
		this.statusCode = status_code;
		this.responseMessage = responseMessage;
		this.responseItem = responseItem;
	}
	
	

	public Response(int status_code, String responseMessage) {
		super();
		this.statusCode = status_code;
		this.responseMessage = responseMessage;
	}



	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int status_code) {
		this.statusCode = status_code;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage( String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getResponseItem() {
		return responseItem;
	}

	public void setResponseItem(T responseItem) {
		this.responseItem = responseItem;
	}

}
