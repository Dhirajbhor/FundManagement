package com.resources;

import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import com.controller.*;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dao.ToolsDao;
import com.entities.*;



@Path("loginRegister")
public class RegisterResource {
	
	@POST
	@Path("/register")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response register(String data)  {
	try {
		
		if(data == null) {					
			return Response.ok().entity("Faild").status(200).build();
		}
		
		JSONParser jsp = new JSONParser();
		JSONObject jso = (JSONObject) jsp.parse(data);
		
	
		
		
		
		
		Group group = new Group();
		 group.setGroupName((String) jso.get("groupName"));
		 group.setStartAmount(Long.parseLong((String) jso.get("groupAmount")));
		 
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
		 
		 UserSession session = new UserSession();
		  String tokan = ToolsDao.generateTokan();
		  session.setTokan(tokan);
		  session.setCreatedDate(group.getCreatedDate());
		  
		  LoginRegisterController registerController = new LoginRegisterController();
		  
		  long sessionId = registerController.register(group, user, session);
		  
		  System.out.println(user);
		  System.out.println(group);
		  System.out.println(session);
	 

	  
	  	if(sessionId > 0) {
			String sessionid = Long.toString(sessionId);
			String groupId = Long.toString(user.getGroupId());
			return Response.ok().entity("Register Successsful").cookie(new NewCookie("fundloginTokan", tokan),new NewCookie("userId",sessionid),new NewCookie("groupId",groupId)).build();
		}
			return Response.ok().entity("Faild").status(200).build();
	}catch(Exception e) {
		e.printStackTrace();
		return Response.ok().entity("Faild").status(200).build();
	}
	}

}
