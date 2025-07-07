package com.litmus7.userregistrationsystem.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.litmus7.userregistrationsystem.controller.UserRegistrationController;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.response.Response;

public class UserRegistrationSystem {

	public static void main(String args[]) {
		UserRegistrationController userRegistrationController = new UserRegistrationController();
		boolean flag = true;

		try (Scanner sc = new Scanner(System.in)) {
			while (flag) {

				System.out.print("Menu \n 1.Register User \n 2.Exit \nEnter Choice : ");

				String userName;
				int age = 0;
				String email;
				String password;
				User user;

				int choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {

					while (true) {
						try {
							System.out.println();
							System.out.print("Enter user name: ");
							userName = sc.nextLine();
							Response validateUserNameResponse = userRegistrationController.validateUserName(userName);
							if (validateUserNameResponse.getStatusCode() == 200) {
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

					Response validateAgeResponse = userRegistrationController.validateAge(age);
					if (validateAgeResponse.getStatusCode() == 400) {
						System.out.println(validateAgeResponse.getResponseMessage());
						System.out.println();
						continue;
					}

					while (true) {
						try {
							System.out.print("Enter email: ");
							email = sc.nextLine();
							Response validateEmailResponse = userRegistrationController.validateEmail(email);
							if (validateEmailResponse.getStatusCode() == 200) {
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
							Response validatePasswordResponse = userRegistrationController.validatePassword(password);
							if (validatePasswordResponse.getStatusCode() == 200) {
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

					user = new User(userName, age, email, password);
					Response RegisterUserInDbResponse = userRegistrationController.RegisterUserInDb(user);

					if (RegisterUserInDbResponse.getStatusCode() == 200) {
						System.out.println();
						System.out.println(RegisterUserInDbResponse.getResponseMessage());
						System.out.println(user);
						System.out.println();
					} else {
						System.out.println();
						System.out.println(RegisterUserInDbResponse.getResponseMessage());
						System.out.println();
					}
				}

				else if (choice == 2) {
					System.out.println("Program Terminated!!");
					flag = false;
				} else {
					System.out.println("Invalid Choice");
					System.out.println();
				}

			}
		}

	}

}
