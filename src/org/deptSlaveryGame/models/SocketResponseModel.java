package org.deptSlaveryGame.models;

import java.io.Serializable;

import org.deptSlaveryGame.socket.interpreter.RequestType;

public class SocketResponseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3768948653347271536L;
	private RequestType requestType;
	private boolean success;
	private String errorMessage;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
