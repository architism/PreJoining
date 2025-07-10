package com.litmus7.userregistrationsystem.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.litmus7.userregistrationsystem.controller.UserRegistrationController;
import com.litmus7.userregistrationsystem.dto.Response;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.util.Constant;

public class UserRegistrationSystem {

	public static void main(String args[]) {
		UserRegistrationController userRegistrationController = new UserRegistrationController();

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {

				System.out.print("Menu \n 1.Register User \n 2.View User By Id \n 3.Exit \nEnter Choice : ");

				String userName;
				int age = 0;
				String email;
				String password;
				

				int choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {

					while (true) {
						try {
							System.out.println();
							System.out.print("Enter user name: ");
							userName = sc.nextLine();
							Response<String> validateUserNameResponse = userRegistrationController
									.isValidUserName(userName);
							if (validateUserNameResponse.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
								break;
							} else {
								System.out.println(validateUserNameResponse.getResponseMessage());
								System.out.println();
							}
						} catch (InputMismatchException e) {
							System.out.println("Name should be a string");
							System.out.println();
						}
					}
					while (true) {
						try {
							System.out.print("Enter age: ");
							age = sc.nextInt();
							sc.nextLine();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Age should be an integer");
							System.out.println();

							sc.nextLine();

						}
					}

					Response<String> validateAgeResponse = userRegistrationController.isValidAge(age);
					if (validateAgeResponse.getStatusCode() == Constant.ERROR_STATUS_CODE) {
						System.out.println(validateAgeResponse.getResponseMessage());
						System.out.println();
						continue;
					}

					while (true) {
						try {
							System.out.print("Enter email: ");
							email = sc.nextLine();
							Response<String> validateEmailResponse = userRegistrationController.isValidEmail(email);
							if (validateEmailResponse.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
								break;
							} else {
								System.out.println(validateEmailResponse.getResponseMessage());
								System.out.println();
							}

						} catch (InputMismatchException e) {
							System.out.println("Email should be a String");
							System.out.println();
						}
					}

					while (true) {
						try {
							System.out.print("Enter password: ");
							password = sc.nextLine();
							Response<String> validatePasswordResponse = userRegistrationController
									.isValidPassword(password);
							if (validatePasswordResponse.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
								break;
							} else {
								System.out.println(validatePasswordResponse.getResponseMessage());
								System.out.println();
							}

						} catch (InputMismatchException e) {
							System.out.println("Password should be a String");
							System.out.println();
						}
					}

					Response<User> registerUserResponse = userRegistrationController
							.registerUser(new User(userName, age, email, password));

					if (registerUserResponse.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
						System.out.println();
						System.out.println(registerUserResponse.getResponseMessage());
						System.out.println(registerUserResponse.getResponseItem());
						System.out.println();
					} else {
						System.out.println();
						System.out.println(registerUserResponse.getResponseMessage());
						System.out.println();
					}
				}

				else if (choice == 2) {
					System.out.println();
					System.out.print("Enter User ID to search : ");
					int userId = sc.nextInt();
					sc.nextLine();
					Response<User> response = userRegistrationController.viewUserById(userId);
					if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
						System.out.println(response.getResponseMessage());
						System.out.println("User Details");
						System.out.println("ID : " + response.getResponseItem().getUserId());
						System.out.println("Username : " + response.getResponseItem().getUsername());
						System.out.println("Age : " + response.getResponseItem().getAge());
						System.out.println("Email : " + response.getResponseItem().getEmail());
						System.out.println();
					} else {
						System.out.println(response.getResponseMessage());
						System.out.println();
					}
				}

				else if (choice == 3) {
					System.out.println("Program Terminated!!");
					break;
				} else {
					System.out.println("Invalid Choice");
					System.out.println();
				}

			}
		}

	}

}
