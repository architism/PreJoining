package com.litmus7.userregistrationsystem.controller;

import com.litmus7.userregistrationsystem.dao.UserDbDao;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.DbAccessException;
import com.litmus7.userregistrationsystem.exception.DbEmailException;
import com.litmus7.userregistrationsystem.exception.DbUsernameException;
import com.litmus7.userregistrationsystem.exception.InvalidAgeException;
import com.litmus7.userregistrationsystem.exception.InvalidEmailException;
import com.litmus7.userregistrationsystem.exception.InvalidUserNameException;
import com.litmus7.userregistrationsystem.exception.WeakPasswordException;
import com.litmus7.userregistrationsystem.response.Response;
import com.litmus7.userregistrationsystem.validation.UserRegistration;

public class UserRegistrationController {

	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int ERROR_STATUS_CODE = 400;

	private UserDbDao userDbDao = new UserDbDao();
	private UserRegistration userRegistration = new UserRegistration();

	public Response validateUserName(String userName) {
		try {
			userRegistration.validateUsername(userName);
		} catch (InvalidUserNameException e) {
			return new Response(ERROR_STATUS_CODE, e.getMessage());
		}

		return new Response(SUCCESS_STATUS_CODE, "Entered username is valid.");
	}

	public Response validateAge(int age) {
		try {
			userRegistration.validateAge(age);
		} catch (InvalidAgeException e) {
			return new Response(ERROR_STATUS_CODE, e.getMessage());
		}
		return new Response(SUCCESS_STATUS_CODE, "Age is valid.");
	}

	public Response validateEmail(String email) {
		if (email == null || email == " ") {
			return new Response(ERROR_STATUS_CODE, "Email cannot be empty");

		}
		try {
			userRegistration.validateEmail(email);

		} catch (InvalidEmailException e) {
			return new Response(ERROR_STATUS_CODE, e.getMessage());
		}

		return new Response(SUCCESS_STATUS_CODE, "Email is valid.");
	}

	public Response validatePassword(String password) {
		if (password == null || password == " ") {
			return new Response(ERROR_STATUS_CODE, "Password cannot be empty");

		}
		try {
			userRegistration.validatePassword(password);
		} catch (WeakPasswordException e) {
			return new Response(ERROR_STATUS_CODE, e.getMessage());
		}
		return new Response(SUCCESS_STATUS_CODE, "Password is valid.");
	}

	public Response RegisterUserInDb(User user) {

		if (user == null) {
			return new Response(ERROR_STATUS_CODE, "user cannot be empty");

		}
		try {
			userDbDao.RegisterUserInDb(user);
		} catch (DbAccessException e) {
			return new Response(ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());
		} catch (DbUsernameException e) {
			return new Response(ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());
		} catch (DbEmailException e) {
			return new Response(ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());
		}

		return new Response(SUCCESS_STATUS_CODE, "User Successfully Registered!!");

	}

}
