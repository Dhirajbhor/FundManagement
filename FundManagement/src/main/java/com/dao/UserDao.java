package com.dao;
import com.dataBase.*;
import com.entities.*;
import java.sql.*;
import java.util.List;

public class UserDao {
	private userdb db;
	private Connection connection;
	private String userName;
	private String password;
	
	public UserDao(){
		db = new userdb();
		userName = "postgres";
		password = "Gamedhiraj@123";
	}
	
	public List<User> getAll() throws SQLException {
		try {
			connection = userdb.connect(userName, password);
			List<User> users = db.getAll(connection);
			return users;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			connection.close();
		}
	}
	
	public User getById(long id) throws SQLException {
		try {
			connection = userdb.connect(userName, password);
			User user = db.getById(connection, id);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			connection.close();
		}
	}
	
	public String add(User user) throws SQLException {
		try {
			connection = userdb.connect(userName, password);
			long id = db.add(connection, user);
			if(!(id <= 0 )) {
				return "success";
			}
			return "failed";
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}finally {
			connection.close();
		}
	}
	
	public String update(User user) throws SQLException {
		try {
			connection = userdb.connect(userName, password);
			long id = db.update(connection, user);
			if(!(id <= 0 ) && id == 1) {
				return "success";
			}
			return "failed";
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}finally {
			connection.close();
		}
		
	}
	
	

}
