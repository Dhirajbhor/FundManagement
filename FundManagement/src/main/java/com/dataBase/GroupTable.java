package com.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entities.Group;

public class GroupTable extends DataBase{
	
	
	
	//add groups details in the database;
	public long addGroup(Connection connection,Group group) {
		String query = "INSERT INTO groups(groupname,createddate) VALUES(?,?) RETURNING id;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, group.getGroupName());
			statement.setDate(2, group.getCreatedDate());
			
			ResultSet result = statement.executeQuery();
			if(result != null) {
				result.next();
				long id = result.getLong("id");
				return id;
			}
			return Integer.MIN_VALUE;
			
		}catch(Exception e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
	}
	
	//get the group details by group name
	public String getGroupName(Connection connection,long id) {
		String query = "SELECT groupname FROM groups WHERE id = "+ id +" WHERE isdeleted = false LIMIT 1;";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			if(result != null) {
				result.next();
				return result.getString("groupname");
			}
			return null;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//update group details
	public int update(Connection connection,Group group) {
		String query = "UPDATE groups SET groupname = ? WHERE id = ?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, group.getGroupName());
			statement.setLong(2,group.getId());
			
			int result = statement.executeUpdate();
			
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
		
	}
	
	
	//get group details by id
	public Group getGroup(Connection connection,long id) {
		String query = "SELECT * FROM groups WHERE id = " + id + " WHERE isdeleted = false LIMIT 1;";
		try {
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(query);
		
			if(result != null) {
				Group group = new Group();
				result.next();
				group.setId(result.getLong("id"));
				group.setGroupName(result.getString("groupname"));
				group.setCreatedDate(result.getDate("createddate"));
				
				return group;
			}
			
			return null;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
