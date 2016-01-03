package org.deptSlaveryGame.socket.interpreter;

import org.deptSlaveryGame.db.User;
import org.deptSlaveryGame.models.SignUpRequestModel;
import org.deptSlaveryGame.models.SignUpResponseModel;
import org.deptSlaveryGame.models.UserModel;
import org.deptSlaveryGame.socket.RWebSocket;

public class SignUp {
	public static SignUpResponseModel process(SignUpRequestModel request, RWebSocket rWebSocket) {
		SignUpResponseModel response = new SignUpResponseModel();
		response.setRequestType(RequestType.signUp);

		UserModel userModel = new UserModel();
		userModel.setEmail(request.getEmail());
		userModel.setName(request.getName());
		userModel.setPassword(request.getPassword());
		userModel.setSurname(request.getSurname());
		userModel = User.create(userModel);

		if(userModel.getUserid() != 0)
			response.setSuccess(true);
		else
			response.setErrorMessage("SignUp error. Email may have already been registered.");
		return response;
	}
}
