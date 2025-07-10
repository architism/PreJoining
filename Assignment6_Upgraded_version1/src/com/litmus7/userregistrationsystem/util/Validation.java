package com.litmus7.userregistrationsystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean isValidUsername(String userName) {
		if (userName == null || userName == " ") {
			return false;
		}
		return true;
	}

	public boolean isValidAge(int age) {
		if (age < 18 || age > 60) {
			return false;
		}
		return true;
	}

	public boolean isValidEmail(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.matches())
			return false;
		return true;
	}

	public boolean isValidPassword(String password) {
		if (password.length() < 6) {
			return false;
		}
		return true;
	}

}
