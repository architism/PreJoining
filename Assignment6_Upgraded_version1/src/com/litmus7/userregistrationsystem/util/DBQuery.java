package com.litmus7.userregistrationsystem.util;

public class DBQuery {

	public static final String addUserQuery = "INSERT INTO user(name, age, email, password) " + "VALUES(?,?,?,?)";
	public static final String getUserByNameQuery = "SELECT user_id, name, age, email FROM user WHERE name=?";
	public static final String getUserByEmailQuery = "SELECT user_id, name, age, email FROM user WHERE email=?";
	public static final String getUserByIdQuery = "SELECT user_id, name, age, email FROM user WHERE user_id=?";
}
