package org.deptSlaveryGame.models;

public class GameJoinRequestModel extends SocketRequestModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4028836306758644747L;
	private int tableId;
	private String tablePassword;

	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTablePassword() {
		return tablePassword;
	}
	public void setTablePassword(String tablePassword) {
		this.tablePassword = tablePassword;
	}
}
