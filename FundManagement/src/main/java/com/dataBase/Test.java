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
		
		java.util.Date todayDate = new java.util.Date();
		
		Date date = new Date(todayDate.getYear(),todayDate.getMonth(),todayDate.getDay());
		Timestamp stamp = new Timestamp(todayDate.getYear(),todayDate.getMonth(),todayDate.getDay(),todayDate.getHours(),todayDate.getMinutes(),todayDate.getSeconds(),0);
		
		
		UserSession us = new UserSession(1,"adfdbcdefgh",date,stamp);
		
		
		int id = ut.updateSession(con, us);
		System.out.println(id);
		
		//User user = new User(2,"dhiajbhor","pranit","bhor","jadhavwadi123","bhormala","pune","maharastra","dhirajbhor11@gmail.com","7972337103","1234567890","123456789012","gamedhiraj@123","asdfgh",false,1);
	
		//long id = ut.add(con, user);
		
		//System.out.println(id);
		
		//ut.update(con, user);
		
		//User user1 = ut.getById(con, 2);
		
		//System.out.println(user1);
		
		String tokan = ut.getTokan(con, 1);
		
		
		
		ut.disconnect(con);
	
	}
	


}
