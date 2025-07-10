package com.litmus7.userregistrationsystem.dto;

public class Response<T> {

	private int statusCode;
	private String responseMessage;
	private T responseItem;


	public Response(int statusCode, String responseMessage) {
		super();
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
	}

	public Response(int statusCode, String responseMessage, T responseItem) {
		super();
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responseItem = responseItem;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getResponseItem() {
		return responseItem;
	}

	public void setResponseItem(T responseItem) {
		this.responseItem = responseItem;
	}

}
