package org.deptSlaveryGame.socket.interpreter;

import org.deptSlaveryGame.db.GameTable;
import org.deptSlaveryGame.models.GameCreateRequestModel;
import org.deptSlaveryGame.models.GameCreateResponseModel;
import org.deptSlaveryGame.models.GameTableModel;
import org.deptSlaveryGame.socket.RWebSocket;

public class GameCreate {

	public static GameCreateResponseModel process(GameCreateRequestModel request, RWebSocket rWebSocket)
	{	
		GameTableModel gameTableModel = new GameTableModel();
		gameTableModel.setTableName(request.getTableName());
		gameTableModel.setTablePassword(request.getTablePassword());
		gameTableModel.setUserId(rWebSocket.getUser().getUserid());
		gameTableModel = GameTable.create(gameTableModel);

		rWebSocket.setTable(gameTableModel);
		rWebSocket.setAdminOfTable(true);
		GameCreateResponseModel response = new GameCreateResponseModel();
		response.setRequestType(RequestType.gameCreate);
		response.setSuccess(true);
		return response;
	}
}
