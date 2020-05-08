package com.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.entities.Group;
import com.entities.User;
import com.entities.UserSession;

import java.io.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//UserTable ut = new UserTable();
		UserSessionTable ut = new UserSessionTable();
		
		
		Connection con =  ut.connect();
		
		boolean check = ut.isUserFirstTime(con,100);
		System.out.println(check);
		
		
		
		
		
		ut.disconnect(con);
	
	}
	


}
