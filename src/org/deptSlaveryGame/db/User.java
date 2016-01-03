package org.deptSlaveryGame.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.deptSlaveryGame.Functions;
import org.deptSlaveryGame.models.GameCreateRequestModel;
import org.deptSlaveryGame.models.GameTableModel;
import org.deptSlaveryGame.models.UserModel;
import org.eclipse.jetty.util.security.Credential.MD5;

public class User {
	
	public static UserModel create(UserModel user)
	{
		String query = 
			"INSERT INTO `BoardGame`.`User`" + 
			"(" + 
			"`email`," + 
			"`name`," + 
			"`surname`," + 
			"`password`)" + 
			"VALUES" + 
			"(?,?,?,?)";
		
		Connection con = null;
		try
		{
			con = MySQL.getConnection();
			PreparedStatement pstatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, user.getEmail());
			pstatement.setString(2, user.getName());
			pstatement.setString(3, user.getSurname());
			pstatement.setString(4, Functions.getMD5(user.getPassword()));

			int affectedRows = pstatement.executeUpdate();
			if(affectedRows > 0)
			{
				ResultSet rs = pstatement.getGeneratedKeys();
			    if(rs.next())
			    	user.setUserid(rs.getInt(1));
			    rs.close();
			}
			pstatement.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MySQL.closeConnection(con);
		}
		return user;
	}

	public static UserModel signIn(UserModel userModel)
	{
		Connection conn = null; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		UserModel model = null;
		
		String query = "SELECT * FROM User where email = ? and password = ?";

		try
		{
			conn = MySQL.getConnection();
			pst = conn.prepareStatement(query);
			pst.setString(1, userModel.getEmail());
			pst.setString(2, Functions.getMD5(userModel.getPassword()));
			rs = pst.executeQuery();
			if(rs.next())
			{
				model = new UserModel();
				model.setEmail(rs.getString("email"));
				model.setName(rs.getString("name"));
				model.setPassword(null);
				model.setSurname(rs.getString("surname"));
				model.setUserid(rs.getInt("userid"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return model;
	
	}
}
