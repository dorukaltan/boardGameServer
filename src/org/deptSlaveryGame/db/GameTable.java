package org.deptSlaveryGame.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.deptSlaveryGame.models.GameCreateRequestModel;
import org.deptSlaveryGame.models.GameTableModel;

public class GameTable {
	
	public static GameTableModel create(GameTableModel gameTableModel)
	{
		String query = 
			"INSERT INTO `BoardGame`.`GameTable`" + 
			"(" + 
			"`userId`," +  
			"`name`)" + 
			"VALUES" + 
			"(" + 
			"?," + 
			"?,?);";
		
		Connection con = null;
		try
		{
			con = MySQL.getConnection();
			PreparedStatement pstatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstatement.setInt(1, gameTableModel.getUserId());
			pstatement.setString(2, gameTableModel.getTableName());
			pstatement.setString(3, gameTableModel.getTablePassword());
			
			int affectedRows = pstatement.executeUpdate();
			if(affectedRows > 0)
			{
				ResultSet rs = pstatement.getGeneratedKeys();
			    if(rs.next())
			    	gameTableModel.setTableId(rs.getInt(1));
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
		return gameTableModel;
	}

	public static List<GameTableModel> list()
	{
		List<GameTableModel> gameTables = new ArrayList<GameTableModel>();
		Connection conn = null; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		String query = "SELECT * FROM GameTable where status = 'A' order by createtime desc";

		try
		{
			conn = MySQL.getConnection();
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			GameTableModel model = null;
			while(rs.next())
			{
				model = new GameTableModel();
				model.setTableId(rs.getInt("tableId"));
				model.setUserId(rs.getInt("userid"));
				model.setTableName(rs.getString("name"));
				model.setTablePassword(rs.getString("password"));
				gameTables.add(model);
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
		return gameTables;
	}

	public static GameTableModel getGameTableByIdAndPassword(GameTableModel gameTableModel)
	{
		Connection conn = null; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		String query = "SELECT * FROM GameTable where "
							+ "status = 'A' and "
							+ "tableId = ? and "
							+ "tablePassword = ? "
							+ "order by createtime desc";

		try
		{
			conn = MySQL.getConnection();
			pst = conn.prepareStatement(query);
			pst.setInt(1, gameTableModel.getTableId());
			pst.setString(2, gameTableModel.getTablePassword());
			rs = pst.executeQuery();
			GameTableModel model = null;
			if(rs.next())
			{
				model = new GameTableModel();
				model.setTableId(rs.getInt("tableId"));
				model.setUserId(rs.getInt("userid"));
				model.setTableName(rs.getString("name"));
				model.setTablePassword(null);
			}
			else
			{
				gameTableModel = null;
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
		return gameTableModel;
	}
}
