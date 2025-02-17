package com.gcu.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


//model for User class
public class UserModel {
    //all the user class properties
	@NotNull(message="First Name must be filled out")
	@Size(min=1, max=20, message="First Name must be between 1 and 20")
	private String fName;
	
	@NotNull(message="Last Name must be filled out")
	@Size(min=1, max=20, message="Last name must be between 1 and 20 characters")
	private String lName;
	
	@NotNull(message="Password must be filled out")
	@Size(min=1, max=20, message="email must be between 1 and 20 characters")
	private String email;
	
	@NotNull(message="Phone number must be filled out")
	@Size(min=10, max=11, message="Phone Number must be between 10 and 11 characters")
	private String pNumber;
	
	@NotNull(message="Username must be filled out")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	@NotNull(message="Password must be filled out")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;

	private String fullName;
	
	
	//user model constructor
	public UserModel(String fName, String lName, String email, String pNumber, String username, String password) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pNumber = pNumber;
		this.username = username;
		this.password = password;
		this.fullName = fName + " " + lName;
		
		
	}
	
	
	
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pNumber
	 */
	public String getpNumber() {
		return pNumber;
	}

	/**
	 * @param pNumber the pNumber to set
	 */
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}




	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName() {
		this.fullName = fName + " " + lName;;
	}
}
