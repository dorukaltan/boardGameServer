package org.deptSlaveryGame.test.client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Communication 
{	
	public Socket socket;
	public ObjectOutputStream out;
	public ObjectInputStream in;
	public DataOutputStream dataOut;
	public DataInputStream dataIn;
	
	public Communication(Socket socket) throws IOException
	{
		this.socket = socket;
		out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(socket.getInputStream());
		
		dataOut = new DataOutputStream(socket.getOutputStream());
		dataOut.flush();
		dataIn = new DataInputStream(socket.getInputStream());
	}
	
	public Socket getSocket()
	{
		
		return socket;
	}
	
	public void sendMessage(String message) throws IOException
	{
		out.writeObject(message);
		out.flush();
	}
	
	public String getMessage() throws IOException, ClassNotFoundException
	{
		return (String)in.readObject();
	}
	
	public void sendObject(Object object) throws IOException
	{
		out.writeObject(object);
		out.flush();
	}
	
	public Object getObject() throws IOException, ClassNotFoundException
	{
		return in.readObject();
	}
	
//	public void sendData(byte [] data) throws IOException
//	{
//		MessagePackage messagePackage = new MessagePackage("send data");
//		messagePackage.put("data_length", data.length);
//		sendObject(messagePackage);
//		dataOut.write(data);
//		dataOut.flush();
//	}
	
	public byte [] getData(int byteLength) throws IOException
	{
		byte [] byte0 = new byte [byteLength];
		
		System.out.println(dataIn.read(byte0));
		
		return byte0;
	}
	
	public void close() throws IOException
	{
		in.close();
		out.close();
		socket.close();
	}

}