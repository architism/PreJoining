package com.litmus7.userregistrationsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.litmus7.userregistrationsystem.exception.InvalidAgeException;
import com.litmus7.userregistrationsystem.exception.InvalidEmailException;
import com.litmus7.userregistrationsystem.exception.InvalidUserNameException;
import com.litmus7.userregistrationsystem.exception.WeakPasswordException;

public class UserRegistration {

	public void validateUsername(String userName) throws InvalidUserNameException {

		if (userName == null || userName == " ") {

			throw new InvalidUserNameException("Entered Username is invalid.");

		}

	}

	public void validateAge(int age) throws InvalidAgeException {
		if (age < 18 || age > 60) {
			throw new InvalidAgeException("Account cannot be created for " + age + " aged user.");
		}
	}

	public void validateEmail(String email) throws InvalidEmailException {

		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.matches())
			throw new InvalidEmailException("Entered email is invalid, must contain '@' and '.'");
	}

	public void validatePassword(String password) throws WeakPasswordException {
		if (password.length() < 6) {
			throw new WeakPasswordException("Entered password is weak, must be atleast 6 chracters long");

		}
	}

}
