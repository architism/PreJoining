package com.litmus7.userregistrationsystem.service;

import com.litmus7.userregistrationsystem.dao.UserDao;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.DbAccessException;
import com.litmus7.userregistrationsystem.exception.EmailAlreadyExistsException;
import com.litmus7.userregistrationsystem.exception.UserAlreadyExistsException;
import com.litmus7.userregistrationsystem.exception.UserNotFoundException;
import com.litmus7.userregistrationsystem.exception.UserRegistrationServiceException;

public class UserRegistrationService {
	private UserDao userDao = new UserDao();

	public User addUser(User user)
			throws UserAlreadyExistsException, UserRegistrationServiceException, EmailAlreadyExistsException {
		try {

			if (userDao.getUserByName(user.getUsername()) != null)
				throw new UserAlreadyExistsException("entered username is already taken.");
			if (userDao.getUserByEmail(user.getEmail()) != null)
				throw new EmailAlreadyExistsException("entered email is already registered.");
			User addedUser = userDao.addUser(user);
			return addedUser;
		} catch (DbAccessException e) {
			throw new UserRegistrationServiceException("Could not add user.", e);
		}
	}

	public User fetchUserById(int userId) throws UserNotFoundException, UserRegistrationServiceException {
		try {
			User foundUser = userDao.getUserById(userId);
			if (foundUser == null)
				throw new UserNotFoundException("User not found in database.");
			return foundUser;
		} catch (DbAccessException e) {
			throw new UserRegistrationServiceException("Could not get user by user Id.", e);
		}

	}
}
