package com.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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


	
}
