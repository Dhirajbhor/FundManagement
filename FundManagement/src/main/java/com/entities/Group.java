package com.entities;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Group {
	private long id;
	private String groupName;
	private boolean isDeleted;
	private Date createdDate;
	private long startAmount;
	
	
	@SuppressWarnings("deprecation")
	public Group() {
		super();
		this.id = 0;
		this.groupName = null;
		this.isDeleted = false;
		
		//current date is set
		java.util.Date defaultDate = new java.util.Date();
		
		this.createdDate = new Date(defaultDate.getYear(),defaultDate.getMonth(),defaultDate.getDay()) ;
		this.startAmount = 0;

		
	}
	public Group(int id, String groupName, boolean isDeleted, Date createdDate,long startAmount) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.startAmount = startAmount;
	}
	
	public long getStartAmount() {
		return startAmount;
	}
	public void setStartAmount(long startAmount) {
		this.startAmount = startAmount;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", isDeleted=" + isDeleted + ", createdDate="
				+ createdDate + ", startAmount=" + startAmount + "]";
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
