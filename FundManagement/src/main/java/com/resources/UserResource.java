package com.resources;
import javax.ws.rs.Consumes;
import java.sql.*;
import java.util.List;

import com.dao.*;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.User;

@Path("users")
public class UserResource 
{
	private UserDao dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() throws SQLException 
	{
		dao = new UserDao();
		return dao.getAll();

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
