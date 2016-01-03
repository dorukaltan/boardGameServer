package org.deptSlaveryGame.models;

public class GameTableModel {
	private int tableId;
	private int userId;
	private String tableName;
	private String tablePassword;

	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
