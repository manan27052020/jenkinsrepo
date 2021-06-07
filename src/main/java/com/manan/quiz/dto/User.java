package com.manan.quiz.dto;

public class User {

	public User() {
	}

	public String userName;
	public String token;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User(String userName, String token) {
		this.userName = userName;
		this.token = token;
	}

}
