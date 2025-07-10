package com.litmus7.userregistrationsystem.controller;

import com.litmus7.userregistrationsystem.dto.Response;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.EmailAlreadyExistsException;
import com.litmus7.userregistrationsystem.exception.UserAlreadyExistsException;
import com.litmus7.userregistrationsystem.exception.UserNotFoundException;
import com.litmus7.userregistrationsystem.exception.UserRegistrationServiceException;
import com.litmus7.userregistrationsystem.service.UserRegistrationService;
import com.litmus7.userregistrationsystem.util.Constant;
import com.litmus7.userregistrationsystem.util.Validation;

public class UserRegistrationController {

	private UserRegistrationService userService = new UserRegistrationService();
	private Validation userRegistration = new Validation();

	public Response<String> isValidUserName(String userName) {

		if (userRegistration.isValidUsername(userName))
			return new Response<String>(Constant.SUCCESS_STATUS_CODE, "Entered username is valid.");

		return new Response<String>(Constant.ERROR_STATUS_CODE, "Entered Username is invalid.");
	}

	public Response<String> isValidAge(int age) {

		if (userRegistration.isValidAge(age))
			return new Response<String>(Constant.SUCCESS_STATUS_CODE, "Age is valid.");

		return new Response<String>(Constant.ERROR_STATUS_CODE, "Account cannot be created for " + age + " aged user.");

	}

	public Response<String> isValidEmail(String email) {
		if (email == null || email == " ") {
			return new Response<String>(Constant.ERROR_STATUS_CODE, "Email cannot be empty");
		}
		if (userRegistration.isValidEmail(email))
			return new Response<String>(Constant.SUCCESS_STATUS_CODE, "Email is valid.");

		return new Response<String>(Constant.ERROR_STATUS_CODE, "Entered email is invalid, must contain '@' and '.'");

	}

	public Response<String> isValidPassword(String password) {
		if (password == null || password == " ") {
			return new Response<String>(Constant.ERROR_STATUS_CODE, "Password cannot be empty");
		}

		if (userRegistration.isValidPassword(password))
			return new Response<String>(Constant.SUCCESS_STATUS_CODE, "Password is valid.");

		return new Response<String>(Constant.ERROR_STATUS_CODE,
				"Entered password is weak, must be atleast 6 chracters long");

	}

	public Response<User> registerUser(User user) {

		if (user == null) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "user cannot be empty");

		}
		try {

			User addedUser = userService.addUser(user);
			return new Response<User>(Constant.SUCCESS_STATUS_CODE, "User Successfully Registered!!", addedUser);

		} catch (UserAlreadyExistsException e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());

		} catch (EmailAlreadyExistsException e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());
		}

		catch (UserRegistrationServiceException e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "Could not register user, " + e.getMessage());
		}

	}

	public Response<User> viewUserById(int userId) {
		try {
			User foundUser = userService.fetchUserById(userId);
			return new Response<User>(Constant.SUCCESS_STATUS_CODE, "User found!!", foundUser);

		} catch (UserNotFoundException e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "User with ID " + userId + " not found.");
		} catch (UserRegistrationServiceException e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "User could not be searched.");
		} catch (Exception e) {
			return new Response<User>(Constant.ERROR_STATUS_CODE, "An error occured.");
		}

	}

}
