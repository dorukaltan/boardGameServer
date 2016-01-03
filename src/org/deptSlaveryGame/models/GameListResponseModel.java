package org.deptSlaveryGame.models;

import java.util.List;

public class GameListResponseModel extends SocketResponseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8218376932348318901L;
	private List<GameTableModel> gameTableList;

	public List<GameTableModel> getGameTableList() {
		return gameTableList;
	}

	public void setGameTableList(List<GameTableModel> gameTableList) {
		this.gameTableList = gameTableList;
	} 
}
