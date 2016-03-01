package org.deptSlaveryGame.socket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

public class GameServerHandler extends WebSocketHandler
{
	private static final Set<RWebSocket> webSockets = new CopyOnWriteArraySet<RWebSocket>();
	
	public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol)
	{
		RWebSocket webSocket = new RWebSocket();
		return webSocket;
	}

	public static void removeSocketFromList(int userid)
	{
		webSockets.remove(getWebSocketByUserid(userid));
	}
	
	public static RWebSocket getWebSocketByUserid(int userid)
	{
		for(RWebSocket rWebSocket : webSockets)
			if(rWebSocket.getUser().getUserid() == userid)
				return rWebSocket;
		return null;
	}

	public static Set<RWebSocket> getWebsockets() {
		return webSockets;
	}
	
	public static void addWebsocket(RWebSocket rWebSocket)
	{
		getWebsockets().add(rWebSocket);
	}
}