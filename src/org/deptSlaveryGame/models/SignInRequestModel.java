package org.deptSlaveryGame.models;

public class SignInRequestModel extends SocketRequestModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4725379037446656126L;
	private String email;
	private String password;

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
}
