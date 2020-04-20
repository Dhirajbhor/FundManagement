package com.dao;
import com.dataBase.*;
import com.entities.*;
import java.sql.*;
import java.util.List;

public class UserDao {
	private UserTable db;
	private Connection connection;
	
	public UserDao(){
		db = new UserTable();
		connection = db.connect();
	}
	
	public List<User> getAll() throws SQLException {
		try {
			long groupId = 1;
			List<User> users = db.getAll(connection,groupId);
			return users;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getById(long id) throws SQLException {
		try {
			
			User user = db.getById(connection, id);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String add(User user) throws SQLException {
		try {
			connection = db.connect();
			long id = db.add(connection, user);
			if(!(id <= 0 )) {
				return "success";
			}
			return "failed";
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	public String update(User user) throws SQLException {
		try {
			long id = db.update(connection, user);
			if(!(id <= 0 ) && id == 1) {
				return "success";
			}
			return "failed";
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	public boolean isExist(String userName) {
		try {
			User user = db.getByName(connection, userName);
			if(user != null) {
				if(user.getUserName().equals(userName)) 
				return true;
			}
				return false;
				
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	

}
