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
		String query = "SELECT * FROM users WHERE id = " +id+ " AND isdeleted = FALSE LIMIT 1;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(query);
			
			if(resultSet.next()) {
			
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setUserName(resultSet.getString("username"));
				user.setAddress(resultSet.getString("address"));
				user.setDist(resultSet.getString("dist"));
				user.setState(resultSet.getString("state"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMobileNumber(resultSet.getString("mobilenumber"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setPanCardNumber(resultSet.getString("pancardnumber"));
				user.setAdharCardNumber(resultSet.getString("adharcardnumber"));
				user.setPassword(resultSet.getString("password"));
				user.setDeleted(resultSet.getBoolean("isdeleted"));
				user.setKey(resultSet.getString("key"));
				user.setGroupId(resultSet.getLong("groupid"));
				user.setShares(resultSet.getInt("shares"));
				user.setAdmin(resultSet.getBoolean("isadmin"));
				
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			//connection.close();
			return null;
		}
	}
		
	public List<User> getAll(Connection connection,long groupId) {
		String query = "SELECT * FROM users WHERE isdeleted = FALSE AND groupid = "+ groupId +" ORDER BY shares DESC;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
				
				
			if(resultSet != null) {
				List<User> users = new ArrayList<>();
				
					
				while(resultSet.next()) {
					
					User user = new User();
					
					user.setId(resultSet.getLong("id"));
					user.setUserName(resultSet.getString("username"));
					user.setAddress(resultSet.getString("address"));
					user.setDist(resultSet.getString("dist"));
					user.setState(resultSet.getString("state"));
					user.setFirstName(resultSet.getString("firstname"));
					user.setLastName(resultSet.getString("lastname"));
					user.setMobileNumber(resultSet.getString("mobilenumber"));
					user.setEmailId(resultSet.getString("emailid"));
					user.setPanCardNumber(resultSet.getString("pancardnumber"));
					user.setAdharCardNumber(resultSet.getString("adharcardnumber"));
					user.setPassword(resultSet.getString("password"));
					user.setDeleted(resultSet.getBoolean("isdeleted"));
					user.setGroupId(resultSet.getLong("groupid"));
					user.setShares(resultSet.getInt("shares"));
					user.setAdmin(resultSet.getBoolean("isadmin"));
					
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
		String query = "SELECT * FROM users WHERE username = '" +userName+ "'AND isdeleted = FALSE LIMIT 1;";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(query);
			
			if(resultSet.next()) {
				
				User user = new User();
				
				user.setId(resultSet.getLong("id"));
				user.setUserName(resultSet.getString("username"));
				user.setAddress(resultSet.getString("address"));
				user.setDist(resultSet.getString("dist"));
				user.setState(resultSet.getString("state"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMobileNumber(resultSet.getString("mobilenumber"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setPanCardNumber(resultSet.getString("pancardnumber"));
				user.setAdharCardNumber(resultSet.getString("adharcardnumber"));
				user.setPassword(resultSet.getString("password"));
				user.setDeleted(resultSet.getBoolean("isdeleted"));
				user.setKey(resultSet.getString("key"));
				user.setGroupId(resultSet.getInt("groupid"));
				user.setAdmin(resultSet.getBoolean("isadmin"));
				
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
		String query = "INSERT INTO users(firstname,lastname,address,dist,state,mobilenumber,emailid,pancardnumber,adharcardnumber,password,key,groupid,username,shares,isadmin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id ;";
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			 statement.setString(1, user.getFirstName());
			 statement.setString(2, user.getLastName());
			 statement.setString(3, user.getAddress());
			 statement.setString(4, user.getDist());
			 statement.setString(5, user.getState());
			 statement.setString(6, user.getMobileNumber());
			 statement.setString(7, user.getEmailId());
			 statement.setString(8, user.getPanCardNumber());
			 statement.setString(9,user.getAdharCardNumber());
			 statement.setString(10,user.getPassword());
			 statement.setString(11,user.getKey());
			 statement.setLong(12,user.getGroupId());
			 statement.setString(13,user.getUserName());
			 statement.setInt(14,user.getShares());
			 statement.setBoolean(15,user.isAdmin());
			 
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
		String query = "UPDATE users SET firstname = ? ,lastname = ?,address = ?,dist = ?,state = ?,mobilenumber = ?,emailid = ?,pancardnumber = ?,adharcardnumber = ?,isadmin = ?  WHERE id = "+ user.getId() +";";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,user.getFirstName());
			statement.setString(2,user.getLastName());
			statement.setString(3,user.getAddress());
			statement.setString(4,user.getDist());
			statement.setString(5,user.getState());
			statement.setString(6,user.getMobileNumber());
			statement.setString(7,user.getEmailId());
			statement.setString(8,user.getPanCardNumber());
			statement.setString(9,user.getAdharCardNumber());
			statement.setBoolean(10,user.isAdmin());
			
			int result = statement.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
		
	}
	
	public boolean isExistEmailId(Connection con,long groupId,String emailId) {
		if(con == null && groupId == 0 && emailId == null) {
			return false;
		}
		try {
			String query = "SELECT id FROM users WHERE groupid = " +groupId+" AND emailid = '"+emailId+"' LIMIT 1;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				long id = rs.getLong("id");
				if(id > 0) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean isExistAdharCardNumber(Connection con,long groupId,String adharCardNumber) {
		if(con == null && groupId == 0 && adharCardNumber == null) {
			return false;
		}
		try {
			String query = "SELECT id FROM users WHERE groupid = " +groupId+" AND adharcardnumber = '"+adharCardNumber+"' LIMIT 1;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				long id = rs.getLong("id");
				if(id > 0) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean isExistPanCardNumber(Connection con,long groupId,String panCardNumber) {
		if(con == null && groupId == 0 && panCardNumber == null) {
			return false;
		}
		try {
			String query = "SELECT id FROM users WHERE groupid = " +groupId+" AND pancardnumber = '"+panCardNumber+"' LIMIT 1;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				long id = rs.getLong("id");
				if(id > 0) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean isExistMobileNumber(Connection con,long groupId,String mobileNumber) {
		if(con == null && groupId == 0 && mobileNumber == null) {
			return false;
		}
		try {
			String query = "SELECT id FROM users WHERE groupid = " +groupId+" AND mobilenumber = '"+mobileNumber+"' LIMIT 1;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				long id = rs.getLong("id");
				if(id > 0) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean isExistUser(Connection con,String userName) {
		if(con == null && userName == null) {
			return false;
		}
		
		try {
			User user = this.getByName(con, userName);
			if(user.getUserName().equals(userName)) {
				return true;
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	

	

}