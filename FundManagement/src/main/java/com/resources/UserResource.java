package com.resources;
import javax.ws.rs.Consumes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.*;
import com.dataBase.DataBase;
import com.dataBase.UserSessionTable;
import com.dataBase.UserTable;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.entities.User;
import com.entities.UserSession;

@Path("users")
public class UserResource 
{
	private UserDao dao;
	private UserTable userTable;
	private Connection con;
	private UserSessionTable sessionTable;
	
	public UserResource() {
		dao = new UserDao();
		userTable = new UserTable();
		con = DataBase.connect();
		sessionTable = new UserSessionTable();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() throws SQLException 
	{	
		return dao.getAll();
	}
	
	@GET
	@Path("/{groupId}/{userName}")
	public boolean checkUser(@PathParam("groupId") long groupId,@PathParam("userName") String userName) throws SQLException{
		return userTable.isExistUser(con, userName);
	}
	
	@GET
	@Path("/{groupId}/checkEmail/{emailid}")
	public boolean checkEmailId(@PathParam("groupId") long groupId,@PathParam("emailid") String emailId) throws SQLException {
		return userTable.isExistEmailId(con, groupId, emailId);
	}
	
	@GET
	@Path("/{groupId}/checkMobile/{mobilenumber}")
	public boolean checkMobileNumber(@PathParam("groupId") long groupId,@PathParam("mobilenumber") String mobileNumber) throws SQLException {
		return userTable.isExistMobileNumber(con, groupId, mobileNumber);
	}
	
	@GET
	@Path("/{groupId}/checkAdhar/{adharcardnumber}")
	public boolean checkAdharCardNumber(@PathParam("groupId") long groupId,@PathParam("adharcardnumber") String adharCardNumber) throws SQLException {
		return userTable.isExistAdharCardNumber(con, groupId, adharCardNumber);
	}
	
	@GET
	@Path("/{groupId}/checkPan/{pancardnumber}")
	public boolean checkPanCardNumber(@PathParam("groupId") long groupId,@PathParam("pancardnumber") String panCardNumber) throws SQLException {
		return userTable.isExistPanCardNumber(con, groupId, panCardNumber);
	}
	
	@POST 
	@Path("/{groupId}/{userId}/{tokan}/addMember")
	public String addMember(@PathParam("groupId")String groupId,@PathParam("tokan")String tokan,@PathParam("userId")String userId,String data) {
		try{
			
			//if input is null then return failed;
			if(data == null) {
				return "Faild To Add";
			}else if(!sessionTable.checkSession(con,Long.parseLong(userId), tokan)) {
				return "Log Out";
			}
			
			//convert input  json string into json object
			JSONParser jsp = new JSONParser();
			JSONObject jso = (JSONObject) jsp.parse(data);
			
			String date =(String) jso.get("todaysDate");
			long dateTo = Long.parseLong(date);
			Date todaysDate = new Date(dateTo);
			
			
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
			 user.setAdharCardNumber((String) jso.get("adharCardNumber"));
			 user.setPanCardNumber((String) jso.get("panCardNumber"));
			 user.setAdmin(false);
			 user.setGroupId(Long.parseLong(groupId));
			 
			 String password = (String) jso.get("password");
			 user.setPassword(ToolsDao.generatePassword(password));
			 
			 UserSession session = new UserSession();
			  String gentokan = ToolsDao.generateTokan(); // genrate random string.
			  session.setTokan(gentokan);
			  session.setCreatedDate(todaysDate);
			  
			  long memberId = userTable.add(con, user);
			  session.setId(memberId);
			  int id = sessionTable.addSession(con, session);
			  if(id > 0) {
				  return "Member Added";
			  }
			  
			  return "Failed to Add";
		}catch(Exception e) {
			
			e.printStackTrace();
			return "Faild To Add";
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{groupId}/{userId}/{tokan}/{userName}/getUserByName")
	public List<User> getUsersByName(@PathParam("groupId")long groupId,@PathParam("userId")Long userId,@PathParam("tokan")String tokan,@PathParam("userName")String userName) {	
		if(sessionTable.checkSession(con, userId, tokan)) {
			List<User> users = userTable.getAll(con, groupId);
			if(!userName.equals("all")) {
				List<User> sortedUsers = new ArrayList<>();
				for(User user : users) {
					String fullName = user.getFirstName() + " " + user.getLastName();
					if(fullName.equals(userName)) {
						sortedUsers.add(user);
					}
				}
				return sortedUsers;
			}else {
				return users;
			}
		}
		return null;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userid}")
	public User getById(@PathParam("userid")long id) throws SQLException 
	{
		dao = new UserDao();
		return  dao.getById(id);
			
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public String addUser(User user) throws SQLException
	{
		dao = new UserDao();
		String result =  dao.add(user);
		return result;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update")
	public String update(User user) throws SQLException 
	{
		dao = new UserDao();
		String result = dao.update(user);
		return result;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	public String delete(@PathParam("userid")long id) {
			return "userDeleted" +id;
	}
	
}