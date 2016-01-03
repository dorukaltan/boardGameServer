package org.deptSlaveryGame.models;

public class GameCreateRequestModel extends SocketRequestModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -290745412080244720L;
	private String tableName;
	private String tablePassword;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTablePassword() {
		return tablePassword;
	}
	public void setTablePassword(String tablePassword) {
		this.tablePassword = tablePassword;
	}
}
