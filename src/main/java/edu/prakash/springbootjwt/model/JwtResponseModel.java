package edu.prakash.springbootjwt.model;

public class JwtResponseModel {
	private String token;

	public JwtResponseModel() {
	}

	public JwtResponseModel(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
