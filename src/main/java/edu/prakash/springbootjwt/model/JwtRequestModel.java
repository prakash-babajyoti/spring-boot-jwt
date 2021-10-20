package edu.prakash.springbootjwt.model;

public class JwtRequestModel {
	private String userName;
	private String password;

	public JwtRequestModel() {
	}

	public JwtRequestModel(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequestModel [username=" + userName + ", password=" + password + "]";
	}

}
