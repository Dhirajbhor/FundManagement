package com.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserSession {
	private long id;
	private String tokan;
	private Date createdDate;
	private Timestamp lastUpdated;
	
	
	
	public UserSession(long id, String tokan, Date createdDate, Timestamp lastUpdated) {
		super();
		this.id = id;
		this.tokan = tokan;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
	}

	public UserSession() {
		super();
		this.id = 0;
		this.tokan = null;
		this.createdDate = null;
		this.lastUpdated = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTokan() {
		return tokan;
	}

	public void setTokan(String tokan) {
		this.tokan = tokan;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", tokan=" + tokan + ", createdDate=" + createdDate + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	
	
	
	
}
