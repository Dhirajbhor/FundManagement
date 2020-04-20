package com.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.ToolsDao;
import com.dataBase.DataBase;
import com.dataBase.GroupTable;
import com.dataBase.UserSessionTable;
import com.dataBase.UserTable;
import com.entities.Group;
import com.entities.User;
import com.entities.UserSession;


public class LoginRegisterController {
		
	
	
	
	
	public long register(Group group,User user,UserSession session) throws SQLException {
		GroupTable gt;
		UserTable ut;
		UserSessionTable ust;
		Connection con = null;
		try {
			
			con = DataBase.connect();
			gt = new GroupTable();
			long groupId = gt.addGroup(con, group);
			
			user.setGroupId(groupId);
			
			ut = new UserTable();
			String password = ToolsDao.generatePassword(user.getPassword());
			user.setPassword(password);
			long userId = ut.add(con, user);
			
			ust = new UserSessionTable();
			session.setId(userId);

			long sessionId = ust.addSession(con, session);
			
			if(sessionId > 0) {
				return userId;
			}
			return Integer.MIN_VALUE;
		}catch(Exception e) {
			e.printStackTrace();
			return Long.MIN_VALUE;
		}finally {
			con.close();
		}
		
	}
	
}
