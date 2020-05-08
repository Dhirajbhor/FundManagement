package com.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.entities.*;


public class UserSessionTable extends DataBase {
	
	public int addSession(Connection connection,UserSession userSession) {
		String query = "INSERT INTO usersession(tokan,createdate,lastupdated) VALUES(?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1,userSession.getTokan());
			statement.setDate(2, userSession.getCreatedDate());
			statement.setTimestamp(3,userSession.getLastUpdated());
			
			int result = statement.executeUpdate();
			
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
		
	}
	
	public int updateSession(Connection connection,UserSession userSession) {
		String query = "UPDATE usersession SET tokan = ?,lastupdated = ? WHERE id = "+ userSession.getId() +";";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, userSession.getTokan());
			statement.setTimestamp(2, userSession.getLastUpdated());
			
			int result = statement.executeUpdate();
			
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
	}
	
	public String getTokan(Connection connection,long id) {
		String query = "SELECT tokan FROM usersession WHERE id = "+ id +";";
		try {
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(query);
			
			if(result != null) {
				result.next();
				String tokan = result.getString("tokan");
				return tokan;
			}
			
			return null;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkSession(Connection con,long id,String tokan) {
		String dbTokan = this.getTokan(con, id);
		if(dbTokan != null) {
			if(tokan.equals(dbTokan)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isUserFirstTime(Connection con,long id) {
		String query = "SELECT lastupdated FROM usersession WHERE id ="+ id +" LIMIT 1;";
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				Timestamp stamp = rs.getTimestamp("lastupdated");
				if(stamp != null) {
					return false;
				}
				return true;
			}
				return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	

	
}