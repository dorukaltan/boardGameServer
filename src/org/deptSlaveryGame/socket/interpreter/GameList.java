package org.deptSlaveryGame.socket.interpreter;

import java.util.List;

import org.deptSlaveryGame.db.GameTable;
import org.deptSlaveryGame.models.GameListRequestModel;
import org.deptSlaveryGame.models.GameListResponseModel;
import org.deptSlaveryGame.models.GameTableModel;
import org.deptSlaveryGame.socket.RWebSocket;

public class GameList {

	public static GameListResponseModel process(GameListRequestModel request, RWebSocket rWebSocket) {
		List<GameTableModel> gameTableList = GameTable.list();
		GameListResponseModel responseModel = new GameListResponseModel();
		responseModel.setGameTableList(gameTableList);
		responseModel.setRequestType(RequestType.gameList);
		responseModel.setSuccess(true);
		return responseModel; 
	}

}
