package com.entities;

public class UserSession {
	private String id;
	private String tokan;
	private String time;
	
	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserSession(String id, String tokan, String time) {
		super();
		this.id = id;
		this.tokan = tokan;
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserSession [id=" + id + ", tokan=" + tokan + ", time=" + time + "]";
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the tokan
	 */
	public String getTokan() {
		return tokan;
	}
	/**
	 * @param tokan the tokan to set
	 */
	public void setTokan(String tokan) {
		this.tokan = tokan;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
