package org.deptSlaveryGame.socket;

import org.deptSlaveryGame.test.client.HostSettings;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

public class WebSocketServer extends Thread
{
	public static void main(String[] args) {
		new WebSocketServer().start();
	}
	public void run()
	{
	// /* WebSocket Handler
			try
			{
				Server server = new Server(HostSettings.port);
				server.setAttribute("minVersion", "-");
				System.out.println("1");
				GameServerHandler handler = new GameServerHandler();
				
				handler.setHandler(new DefaultHandler());
				server.setHandler(handler);
				System.out.println("2");	
				// 2) Start the Jetty server.
				server.start();System.out.println("3");
				// Jetty  server is stopped when the Thread is interruped.
				server.join();
			}
			catch (Throwable e) {e.printStackTrace();}
			// */ WebSocket Handler
	}
}
