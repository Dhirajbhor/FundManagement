package com.resources;

import com.controller.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dao.ToolsDao;
import com.dataBase.DataBase;
import com.dataBase.GroupTable;
import com.dataBase.UserSessionTable;
import com.dataBase.UserTable;
import com.entities.*;



@Path("loginRegister")
public class LoginRegisterResource {
	
	
	//rest call register 
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject register(String data)  {
		
		JSONObject response = new JSONObject();
		
		try{
				
			//if input is null then return failed;
			if(data == null) {
				response.put("message","Failed");
				return response;
			}
			
			//convert input  json string into json object
			JSONParser jsp = new JSONParser();
			JSONObject jso = (JSONObject) jsp.parse(data);
			
		
			// store group details
			Group group = new Group();
			 group.setGroupName((String) jso.get("groupName"));
			 
			 Object Amount =  jso.get("groupAmount");
			 String startAmount = Amount.toString();
			 
			 group.setStartAmount(Long.parseLong(startAmount));
			 
			//store user details 
			User user = new User();
			 user.setUserName((String) jso.get("userName"));
			 user.setShares(Integer.parseInt((String) jso.get("shares")));
			 user.setFirstName((String) jso.get("firstName"));
			 user.setLastName((String) jso.get("lastName"));
			 user.setAddress((String) jso.get("address"));
			 user.setState((String) jso.get("state"));
			 user.setDist((String) jso.get("dist"));
			 user.setMobileNumber((String) jso.get("mobileNumber"));
			 user.setEmailId((String) jso.get("emailid"));
			 user.setPassword((String) jso.get("password"));
			 user.setAdharCardNumber((String) jso.get("adharCardNumber"));
			 user.setPanCardNumber((String) jso.get("panCardNumber"));
			 user.setAdmin(true);
			 
			 //store session details
			 UserSession session = new UserSession();
			  String tokan = ToolsDao.generateTokan(); // genrate random string.
			  session.setTokan(tokan);
			  session.setCreatedDate(group.getCreatedDate());
			  
			  
			 //controller for register details passed all objects with deatils return inserted userid
			 LoginRegisterController registerController = new LoginRegisterController();
			  long userId = registerController.register(group, user, session);
			  	
			  
			  
			  
		  		if(userId > 0) {
		  			//json object to return response in json fromat
		  			
		  			
		  			response.put("groupName", group.getGroupName());
		  			response.put("tokan",tokan);
		  			response.put("userId", Long.toString(userId));
		  			response.put("message","Register Successsful");
		  			response.put("groupId",Long.toString(user.getGroupId()));
		  			response.put("groupAmount",Long.toString(group.getStartAmount()));
		  			
		  			return response;
		  		}
		  		
		  		response.put("message","Failed");
				return response;
			
		}catch(Exception e) {
		
				e.printStackTrace();
				response.put("message","Failed");
				return response;
			}
	}
	
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject login(String data) {
		
		
		JSONObject response = new JSONObject();
		JSONParser jsp = new JSONParser();
		JSONObject jso = null;
		UserTable userDb = null;
		UserSession userSession = null;
		UserSessionTable sessionDb = null;
		User user = null;
		
		try {
			//geting all input Data.
			jso = (JSONObject) jsp.parse(data);
			String userName = (String) jso.get("userName");
			String password = (String) jso.get("password");
			String newDate =  (String) jso.get("todaysDate");
			
			Long date = Long.parseLong(newDate);
			Timestamp currentDate = new Timestamp(date);
			
			
			Connection con = DataBase.connect();
			userDb = new UserTable();
			user = userDb.getByName(con, userName);
			if(user != null) {
				boolean isValidPassword = ToolsDao.validatePassword(password, user.getPassword());
				if(isValidPassword) {
					String tokan = ToolsDao.generateTokan();
					
					Long userId = user.getId();
					Long groupId = user.getGroupId();
					
					sessionDb = new UserSessionTable();
					
					
					
					GroupTable gt = new GroupTable();
					Group group = gt.getGroup(con, groupId);
					String groupName = group.getGroupName();
					String groupAmount = Long.toString(group.getStartAmount());
					
					
					response.put("groupName", groupName);
					response.put("userId", userId.toString());
					response.put("groupId",groupId);
		  			response.put("groupAmount",groupAmount);
		  			response.put("userName",user.getUserName());
					
					if(sessionDb.isUserFirstTime(con,userId)) {
						response.put("message","first time");
						return response;
					}
					
					
					
					
					userSession = new UserSession();
					
					userSession.setId(userId);
					userSession.setLastUpdated(currentDate);
					userSession.setTokan(tokan);
					
					
					int id = sessionDb.updateSession(con, userSession);
					response.put("tokan",tokan);
					
					if(id > 0) {
						//getting group name.
			  			response.put("message","Login Successsful");
			  			return response;
					}else {
						response.put("message","falid to login");
					}
				}else {
					response.put("message","Invalid Password");
				}
			}else {
				response.put("message","Invalid UserId");
			}
				
			return response;
		}catch(Exception e) {
			e.printStackTrace();
			response.put("message","falid to login");
			return response;
		}
	}
	
	@POST
	@Path("changePassword/{userId}")
	public JSONObject changePassword(@PathParam("userId")long userId,String data) {		
		JSONObject response = new JSONObject();
		JSONParser jsp = new JSONParser();
		JSONObject jso = null;
		UserSession userSession = null;
		UserSessionTable sessionDb = null;
		UserTable userDb = null;
		try {
			//geting all input Data.
			jso = (JSONObject) jsp.parse(data);
			String password = ToolsDao.generatePassword((String) jso.get("password"));
			String newDate =  (String) jso.get("todaysDate");
			String tokan = ToolsDao.generateTokan();
			
			Long date = Long.parseLong(newDate);
			Timestamp currentDate = new Timestamp(date);
			
			Connection con = DataBase.connect();
			
			userDb = new UserTable();
			int id = userDb.updatePassword(con, password, userId);
			
			if(id > 0) {
			
				userSession = new UserSession();
				sessionDb = new UserSessionTable();
				userSession.setId(userId);
				userSession.setLastUpdated(currentDate);
				userSession.setTokan(tokan);
			
				id = sessionDb.updateSession(con, userSession);
				
				if(id > 0) {
					response.put("tokan",tokan);
					response.put("message","Successful");
					return response;
				}
			}
			
			response.put("message","falid");
			return response;
			
		}catch(Exception e) {
			System.out.println(e);
			response.put("message","falid");
			return response;
		}
	}
	
}



	