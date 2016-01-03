package org.deptSlaveryGame.socket.interpreter;

import org.deptSlaveryGame.AccountManagement;
import org.deptSlaveryGame.models.GameCreateRequestModel;
import org.deptSlaveryGame.models.GameCreateResponseModel;
import org.deptSlaveryGame.models.GameJoinRequestModel;
import org.deptSlaveryGame.models.GameJoinResponseModel;
import org.deptSlaveryGame.models.GameListRequestModel;
import org.deptSlaveryGame.models.GameListResponseModel;
import org.deptSlaveryGame.models.SignInRequestModel;
import org.deptSlaveryGame.models.SignInResponseModel;
import org.deptSlaveryGame.models.SignUpRequestModel;
import org.deptSlaveryGame.models.SignUpResponseModel;
import org.deptSlaveryGame.models.SocketRequestModel;
import org.deptSlaveryGame.models.UserModel;
import org.deptSlaveryGame.socket.RWebSocket;

import com.google.gson.Gson;

public class Interpreter {
	public static void process(RWebSocket rWebSocket, SocketRequestModel request, String data)
	{
		Gson gson = new Gson();

		Object response = null;
		switch(request.getRequestType())
		{
			case endTurn:
				break;
			case endTurnInfo:
				break;
			case gameCreate:
				GameCreateRequestModel gameCreateRequestModel = gson.fromJson(data, GameCreateRequestModel.class);
				GameCreateResponseModel gameCreateResponseModel = GameCreate.process(gameCreateRequestModel, rWebSocket);
				response = gameCreateResponseModel; 
				break;
			case gameJoin:
				GameJoinRequestModel gameJoinRequestModel = gson.fromJson(data, GameJoinRequestModel.class);
				GameJoinResponseModel gameJoinResponseModel = GameJoin.process(gameJoinRequestModel, rWebSocket);
				response = gameJoinResponseModel;
				break;
			case gameList:
				GameListRequestModel gameListRequestModel = gson.fromJson(data, GameListRequestModel.class);
				GameListResponseModel gameListResponseModel = GameList.process(gameListRequestModel, rWebSocket);
				response = gameListResponseModel;
				break;
			case gameStart:
				break;
			case signIn:
				SignInRequestModel signInRequestModel = gson.fromJson(data, SignInRequestModel.class);
				SignInResponseModel signInResponseModel = SignIn.process(signInRequestModel, rWebSocket);
				response = signInResponseModel;
				break;
			case signOut:
				break;
			case signUp:
				SignUpRequestModel signUpRequestModel = gson.fromJson(data, SignUpRequestModel.class);
				SignUpResponseModel signUpResponseModel = SignUp.process(signUpRequestModel, rWebSocket);
				response = signUpResponseModel;
				break;
			case throwDice:
				break;
			case throwDiceInfo:
				break;
			default:
				break;
		}

		rWebSocket.sendMessage(response);

//		String[] splited_data = data.split(";");
//
//		if (splited_data[0].equals("authentication request")) {
//			if (splited_data.length < 4) {
//				close("authentication response;unexcepted entry");
//				return;
//			}
//			// FIXME parse the data how it should be
//			User user = AccountManagement.authentication(splited_data[1], splited_data[2]);
//			if (user != null) {
//				userid = user.getUserid();
//				// FIXME: webSockets.add(this);
//			} else
//				close("authentication response;authentication failed");
//		} else if (splited_data[0].equals("add publisher")) {
//			int publisherid = Integer.valueOf(splited_data[1]);
//			if (!publishers.contains(publisherid)) {
//				if (AccountManagement.authorization(userid, publisherid)) {
//					publishers.add(publisherid);
//					sendMessage("add publisher;successful");
//				} else
//					sendMessage("add publisher;authentication failed");
//			} else
//				sendMessage("add publisher;already added");
//
//		} else if (splited_data[0].equals("remove publisher")) {
//			int publisherid = Integer.valueOf(splited_data[1]);
//			if (publishers.contains(publisherid)) {
//				publishers.remove(publishers);
//				sendMessage("remove publisher;successful");
//			} else
//				sendMessage("remove publisher;publisherid isn't in list");
//		} else
//			System.out.println("unhandled request: " + splited_data[0]);
	}
}
