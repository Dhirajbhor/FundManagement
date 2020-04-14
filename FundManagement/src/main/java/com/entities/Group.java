package com.entities;

import java.sql.Date;

public class Group {
	private long id;
	private String groupName;
	private boolean isDeleted;
	private Date createdDate;
	
	
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int id, String groupName, boolean isDeleted, Date createdDate) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", isDeleted=" + isDeleted + ", createdDate="
				+ createdDate + "]";
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param l the id to set
	 */
	public void setId(long l) {
		this.id = l;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
