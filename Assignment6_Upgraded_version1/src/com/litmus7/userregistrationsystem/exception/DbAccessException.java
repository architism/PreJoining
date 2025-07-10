package com.litmus7.userregistrationsystem.exception;

public class DbAccessException extends Exception {

	public DbAccessException(String message, Throwable cause) {
		super(message, cause);

	}

	public DbAccessException(String message) {
		super(message);

	}

}
