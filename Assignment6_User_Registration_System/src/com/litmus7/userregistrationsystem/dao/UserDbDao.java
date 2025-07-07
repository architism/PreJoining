package com.litmus7.userregistrationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.DbAccessException;
import com.litmus7.userregistrationsystem.exception.DbEmailException;
import com.litmus7.userregistrationsystem.exception.DbUsernameException;

public class UserDbDao {

	public void RegisterUserInDb(User user) throws DbAccessException, DbUsernameException, DbEmailException {

		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "user",
					"1234Password");

			PreparedStatement insertStmt = myConn
					.prepareStatement("INSERT INTO user(name, age, email, password) " + "VALUES(?,?,?,?)");

			PreparedStatement usernameCheckStmt = myConn.prepareStatement("SELECT user_id FROM user WHERE name=?");
			PreparedStatement emailCheckStmt = myConn.prepareStatement("SELECT user_id FROM user WHERE email=?");

			usernameCheckStmt.setString(1, user.getUsername());
			ResultSet rs = usernameCheckStmt.executeQuery();
			if (rs.next() != false) {
				throw new DbUsernameException("Username is already in use.");
			}

			emailCheckStmt.setString(1, user.getEmail());
			rs = emailCheckStmt.executeQuery();
			if (rs.next() != false) {
				throw new DbEmailException("Email is already registered.");

			}

			insertStmt.setString(1, user.getUsername());
			insertStmt.setInt(2, user.getAge());
			insertStmt.setString(3, user.getEmail());
			insertStmt.setString(4, user.getPassword());

			insertStmt.executeUpdate();

		} catch (SQLException e) {
			
			throw new DbAccessException("Could not access database.", e);

		}

	}
}
