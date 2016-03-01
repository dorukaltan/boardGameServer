package org.deptSlaveryGame.socket;

import java.io.IOException;
import java.util.Date;

import org.deptSlaveryGame.models.GameTableModel;
import org.deptSlaveryGame.models.SocketRequestModel;
import org.deptSlaveryGame.models.UserModel;
import org.deptSlaveryGame.socket.interpreter.Interpreter;
import org.eclipse.jetty.websocket.WebSocket;

import com.google.gson.Gson;

public class RWebSocket implements WebSocket.OnTextMessage {
	private Connection connection;
	private UserModel user;
	private GameTableModel table;
	private boolean isAdminOfTable;

	private Gson gson = new Gson();
	public void onOpen(Connection connection) {
		Date date = new Date();
		System.out.println("Connected at" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());

		this.connection = connection;
		System.out.println("opened");
//		sendMessage("authentication request");
		//TODO: open a thread which waits 30 seconds and if userid is 0 discounnects the websocket
	}

	public void onMessage(String data) {
		SocketRequestModel request = gson.fromJson(data, SocketRequestModel.class);
		Interpreter.process(this, request, data);
	}

	public void sendMessage(Object data) {
		try {
			String dataJSON = gson.toJson(data);
			connection.sendMessage(dataJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close(String pack) {
		sendMessage(pack);
		// FIXME: removeSocketFromList(userid);
		GameServerHandler.removeSocketFromList(user.getUserid());
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {e.printStackTrace();}
		connection.disconnect();
	}

	public void onClose(int closeCode, String message) {
		System.out.println("closedgg: " + closeCode + "_" + message);
		Date date = new Date();
		System.out.println("Closed at" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public GameTableModel getTable() {
		return table;
	}

	public void setTable(GameTableModel table) {
		this.table = table;
	}

	public boolean isAdminOfTable() {
		return isAdminOfTable;
	}

	public void setAdminOfTable(boolean isAdminOfTable) {
		this.isAdminOfTable = isAdminOfTable;
	}

}