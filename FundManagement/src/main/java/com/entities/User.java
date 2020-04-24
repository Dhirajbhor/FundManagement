package com.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String address;
	private String dist;
	private String state;
	private String emailId;
	private String mobileNumber;
	private String panCardNumber;
	private String adharCardNumber;
	private String password;
	private String key;
	private boolean isDeleted;
	private boolean isAdmin;
	private long groupId;
	private int shares;
	private String message;
	
	
	
	
	public User() {
		super();
		this.id = 0;
		this.userName = null;
		this.firstName = null;
		this.lastName = null;
		this.address = null;
		this.dist = null;
		this.state = null;
		this.emailId = null;
		this.mobileNumber = null;
		this.panCardNumber = null;
		this.adharCardNumber = null;
		this.password = null;
		this.key = null;
		this.isDeleted = false;
		this.groupId = 0;
		this.shares = 0;
		this.isAdmin = false;
		this.message = "";
	}


	public User(long id, String userName, String firstName, String lastName, String address,String dist,
			String state, String emailId, String mobileNumber, String panCardNumber, String adharCardNumber,
			String password, String key, boolean isDeleted, long groupId,int shares,boolean isAdmin,String message) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dist = dist;
		this.state = state;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.panCardNumber = panCardNumber;
		this.adharCardNumber = adharCardNumber;
		this.password = password;
		this.key = key;
		this.isDeleted = isDeleted;
		this.groupId = groupId;
		this.shares = shares;
		this.isAdmin = isAdmin;
		this.message = message;
	}
	
	
	
	
	

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * @return the groupId
	 */
	public long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the dist
	 */
	public String getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(String dist) {
		this.dist = dist;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the panCardNumber
	 */
	public String getPanCardNumber() {
		return panCardNumber;
	}
	/**
	 * @param panCardNumber the panCardNumber to set
	 */
	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	/**
	 * @return the adharCardNumber
	 */
	public String getAdharCardNumber() {
		return adharCardNumber;
	}
	/**
	 * @param adharCardNumber the adharCardNumber to set
	 */
	public void setAdharCardNumber(String adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", dist=" + dist + ", state=" + state + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", panCardNumber=" + panCardNumber + ", adharCardNumber="
				+ adharCardNumber + ", password=" + password + ", key=" + key + ", isDeleted=" + isDeleted
				+ ", groupId=" + groupId + ", shares=" + shares +", isAdmin=" + isAdmin +",message="+ message +"]";
	}
	
	
	
	
	
	

}
