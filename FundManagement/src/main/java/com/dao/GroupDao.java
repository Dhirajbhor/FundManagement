package com.dao;

import com.dataBase.GroupTable;
import com.entities.*;

import java.sql.Connection;

import javax.sql.*;


public class GroupDao {
	
	private Connection con;
	private GroupTable groupTable;
	
	public GroupDao() {
		groupTable = new GroupTable();
		con = groupTable.connect();
		
	}
	
	//added group in the database and return id;
	public long addGroup(Group group){
			long id = 0;
		try {
			id = groupTable.addGroup(con, group);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return id;
		}
	}
	
	
	

}
