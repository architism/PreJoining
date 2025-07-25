package com.litmus7.userregistrationsystem.response;

public class Response {

	private int statusCode;
	private String responseMessage;


	public Response(int statusCode, String responseMessage) {
		super();
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
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

}
