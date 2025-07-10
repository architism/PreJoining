package com.litmus7.userregistrationsystem.dto;

public class User {

	private int userId;
	private String userName;
	private int age;
	private String email;
	private String password;

	public User(String username, int age, String email, String password) {
		super();
		this.userName = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public int getAge() {
		return age;
	}

	public User(int userId, String userName, int age, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User [userId = " + userId + ", username = " + userName + ", age = " + age + ", email = " + email + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
