package com.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String dist;
	private String state;
	private String emailId;
	private String mobileNumber;
	private String panCardNumber;
	private String adharCardNumber;
	
	
	
	public User(long id, String firstName, String lastName, String address, String city, String dist, String state,
			String emailId, String mobileNumber, String panCardNumber, String adharCardNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.panCardNumber = panCardNumber;
		this.adharCardNumber = adharCardNumber;
	}
		
	public User() {
		super();
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", dist=" + dist + ", state=" + state + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", panCardNumber=" + panCardNumber + ", adharCardNumber=" + adharCardNumber + "]";
	}
	
	
	
	
	
	

}
