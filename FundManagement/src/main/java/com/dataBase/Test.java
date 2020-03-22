package com.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.entities.User;

import java.io.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		userdb db = new userdb();
		Connection connection = userdb.connect("postgres","Gamedhiraj@123");
		try {
			if(connection != null) {
				System.out.println("connected");
				User user = db.getByName(connection,"dhirajbhor11@gmail.com");
				user.setFirstName("sundar");
				user.setEmailId("sundarbhor@gmail.com");
				user.setMobileNumber("8895121866");
				user.setId(3);
				List<User> allUsers = db.getAll(connection);
				for(User use : allUsers) {
					System.out.println(use);
				}
				long id = db.update(connection, user);
				System.out.println(id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
	


}
