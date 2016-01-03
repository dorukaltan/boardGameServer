package org.deptSlaveryGame.socket.interpreter;

import org.deptSlaveryGame.AccountManagement;
import org.deptSlaveryGame.models.SignInRequestModel;
import org.deptSlaveryGame.models.SignInResponseModel;
import org.deptSlaveryGame.models.UserModel;
import org.deptSlaveryGame.socket.GameServerHandler;
import org.deptSlaveryGame.socket.RWebSocket;

public class SignIn {
	public static SignInResponseModel process(SignInRequestModel request, RWebSocket rWebSocket) {
		UserModel user = AccountManagement.authentication(request.getEmail(), request.getPassword());
		
		SignInResponseModel response = new SignInResponseModel();
		response.setRequestType(RequestType.signIn);
		if(user != null)
		{
			rWebSocket.setUser(user);
			GameServerHandler.addWebsocket(rWebSocket);
			response.setSuccess(true);
		}
		else
		{
			response.setSuccess(false);
		}

		return response;
	}
}
