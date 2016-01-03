package org.deptSlaveryGame.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySQL
{

	public static Connection getConnection()
	{
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
		  }
		  catch (ClassNotFoundException e) { e.printStackTrace(); }
		  catch (Exception e) { e.printStackTrace(); }

		  try
		  {
			  return DriverManager.getConnection ("jdbc:mysql://localhost:3306/BoardGame","root","root");
		  }
		  catch (SQLException e) { e.printStackTrace(); }
		  
		  return null;
	}

	public static void closeConnection(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} 
		catch (Exception e) {
			System.out.println("Error Close: " + e.getMessage());
			e.printStackTrace();
		}
	}
}