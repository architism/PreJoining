package com.litmus7.userregistrationsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.userregistrationsystem.util.DBColumn;
import com.litmus7.userregistrationsystem.util.DBQuery;
import com.litmus7.userregistrationsystem.util.DBUtil;
import com.litmus7.userregistrationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.DbAccessException;

public class UserDao {

	public User addUser(User user) throws DbAccessException {

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.addUserQuery);) {

			statement.setString(1, user.getUsername());
			statement.setInt(2, user.getAge());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());

			statement.executeUpdate();

			return getUserByName(user.getUsername());

		} catch (SQLException e) {

			throw new DbAccessException("Could not access database.", e);

		}

	}

	public User getUserByName(String userName) throws DbAccessException {

		User foundUser = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getUserByNameQuery);) {

			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				foundUser = new User(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getInt(DBColumn.AGE_COLUMN), resultSet.getString(DBColumn.EMAIL_COLUMN));

			return foundUser;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while searching user by name.", e);
		}
	}

	public User getUserByEmail(String email) throws DbAccessException {

		User foundUser = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getUserByEmailQuery);) {

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				foundUser = new User(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getInt(DBColumn.AGE_COLUMN), resultSet.getString(DBColumn.EMAIL_COLUMN));

			return foundUser;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while searching user by email.", e);
		}
	}

	public User getUserById(int userId) throws DbAccessException {

		User foundUser = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getUserByIdQuery);) {

			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				foundUser = new User(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getInt(DBColumn.AGE_COLUMN), resultSet.getString(DBColumn.EMAIL_COLUMN));

			return foundUser;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while searching user by id.", e);
		}
	}
}
