package org.deptSlaveryGame.models;

import org.deptSlaveryGame.socket.interpreter.RequestType;

import com.google.gson.Gson;

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
public static void main(String[] args) {
	SignInRequestModel model = new SignInRequestModel();
	model.setEmail("email");
	model.setRequestType(RequestType.signIn);
System.out.println(new Gson().toJson(model));
}
}
