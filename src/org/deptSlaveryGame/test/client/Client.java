package org.deptSlaveryGame.test.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(HostSettings.ip, HostSettings.port);
		Communication communication = new Communication(socket);
	}
}
