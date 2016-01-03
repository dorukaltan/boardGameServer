package org.deptSlaveryGame.socket.interpreter;

import org.deptSlaveryGame.db.GameTable;
import org.deptSlaveryGame.models.GameJoinRequestModel;
import org.deptSlaveryGame.models.GameJoinResponseModel;
import org.deptSlaveryGame.models.GameTableModel;
import org.deptSlaveryGame.socket.RWebSocket;

public class GameJoin {

	public static GameJoinResponseModel process(GameJoinRequestModel request, RWebSocket rWebSocket) {

		GameTableModel gameTableModel = new GameTableModel();
		gameTableModel.setTableId(request.getTableId());
		gameTableModel.setTablePassword(request.getTablePassword());
		gameTableModel = GameTable.getGameTableByIdAndPassword(gameTableModel);
		
		GameJoinResponseModel response = new GameJoinResponseModel();
		response.setRequestType(RequestType.gameJoin);
		if(gameTableModel != null)
		{
			response.setSuccess(true);
			rWebSocket.setTable(gameTableModel);
			rWebSocket.setAdminOfTable(false);
		}
		return response;
	}

}
