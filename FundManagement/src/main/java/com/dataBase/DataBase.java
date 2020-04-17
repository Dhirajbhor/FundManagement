package com.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.entities.User;

public abstract class DataBase {
	
	public static Connection connect() {
		
		//user name of the database and password
		String userName = "postgres";
	    String password = "Gamedhiraj@123";
		
	    //connection object.
		Connection connection = null;
		
		// url of to connect postgres database by localhost and /last is database name.
		String url ="jdbc:postgresql://localhost:5432/fundmanagement";
		try {
			//load the postgres driver int the project.
			Class.forName("org.postgresql.Driver");
			//getConnection return the connection object
			connection = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static boolean disconnect(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
