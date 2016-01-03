package org.deptSlaveryGame.models;

import java.io.Serializable;

import org.deptSlaveryGame.socket.interpreter.RequestType;

public class SocketRequestModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2558744585175091726L;
	private RequestType requestType;

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
}
