package com.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.*;


public class UserTable extends DataBase {
	

	//return user data by or from user id
	public User getById(Connection connection,long id) throws SQLException {
		String query = "SELECT * FROM users WHERE id = " +id+ " LIMIT 1;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(query);
			
			if(resultSet.next()) {
			
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setAddress(resultSet.getString("address"));
				user.setCity(resultSet.getString("city"));
				user.setDist(resultSet.getString("dist"));
				user.setState(resultSet.getString("state"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMobileNumber(resultSet.getString("mobilenumber"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setPanCardNumber(resultSet.getString("pancardnumber"));
				user.setAdharCardNumber(resultSet.getString("adharcardnumber"));

				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			//connection.close();
			return null;
		}
	}
		
	public List<User> getAll(Connection connection) {
		String query = "SELECT * FROM users;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
				
				
			if(resultSet != null) {
				List<User> users = new ArrayList<>();
				
					
				while(resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getLong("id"));
					user.setAddress(resultSet.getString("address"));
					user.setCity(resultSet.getString("city"));
					user.setDist(resultSet.getString("dist"));
					user.setState(resultSet.getString("state"));
					user.setFirstName(resultSet.getString("firstname"));
					user.setLastName(resultSet.getString("lastname"));
					user.setMobileNumber(resultSet.getString("mobilenumber"));
					user.setEmailId(resultSet.getString("emailid"));
					user.setPanCardNumber(resultSet.getString("pancardnumber"));
					user.setAdharCardNumber(resultSet.getString("adharcardnumber"));
					
					users.add(user);
				}
					
				return users;
			}
			return null;
				
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public User getByName(Connection connection,String userName) {
		String query = "SELECT * FROM users WHERE emailid = '" +userName+ "' LIMIT 1;";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(query);
			
			if(resultSet.next()) {
			
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setAddress(resultSet.getString("address"));
				user.setCity(resultSet.getString("city"));
				user.setDist(resultSet.getString("dist"));
				user.setState(resultSet.getString("state"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMobileNumber(resultSet.getString("mobilenumber"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setPanCardNumber(resultSet.getString("pancardnumber"));
				user.setAdharCardNumber(resultSet.getString("adharcardnumber"));

				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			//connection.close();
			return null;
		}
	}
	
	public long add(Connection connection,User user) {
		if(user == null) {
			return Integer.MIN_VALUE;
		}
		String query = "INSERT INTO users(firstname,lastname,address,city,dist,state,mobilenumber,emailid,pancardnumber,adharcardnumber) VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING id ;";
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			 statement.setString(1, user.getFirstName());
			 statement.setString(2, user.getLastName());
			 statement.setString(3, user.getAddress());
			 statement.setString(4, user.getCity());
			 statement.setString(5, user.getDist());
			 statement.setString(6, user.getState());
			 statement.setString(7, user.getMobileNumber());
			 statement.setString(8, user.getEmailId());
			 statement.setString(9, user.getPanCardNumber());
			 statement.setString(10,user.getAdharCardNumber());
			 
			 ResultSet resultSet = statement.executeQuery();
			 if(resultSet != null) {
				 resultSet.next();
				 long id = resultSet.getLong("id");
				 return id;
			 }
			 return Integer.MIN_VALUE;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
	}
	
	public int update(Connection connection,User user) {
		if(connection == null || user == null) {
			return Integer.MIN_VALUE;
		}
		String query = "UPDATE users SET firstname = ? ,lastname = ?,address = ?,city = ?,dist = ?,state = ?,mobilenumber = ?,emailid = ?,pancardnumber = ?,adharcardnumber = ? WHERE id = "+ user.getId() +";";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,user.getFirstName());
			statement.setString(2,user.getLastName());
			statement.setString(3,user.getAddress());
			statement.setString(4,user.getCity());
			statement.setString(5,user.getDist());
			statement.setString(6,user.getState());
			statement.setString(7,user.getMobileNumber());
			statement.setString(8,user.getEmailId());
			statement.setString(9,user.getPanCardNumber());
			statement.setString(10,user.getAdharCardNumber());
			
			int result = statement.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
		
	}
	

	

}
