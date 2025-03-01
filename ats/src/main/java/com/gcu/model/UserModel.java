package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/*
 * user in applicatino with user details
 * provides all getter and setters methods for properties
 */

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
	
	/*
	 * user model constructor
	 */
	

	public UserModel(String fName, String lName, String email, String pNumber, String username, String password) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pNumber = pNumber;
		this.username = username;
		this.password = password;
		this.fullName = fName + " " + lName;
		
		
	}
	
	/**
     * Default constructor for UserModel.
     */
    public UserModel() {
        // Default constructor
    }

    /**
     * @return The first name of the user.
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param fName The first name to set.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return The last name of the user.
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lName The last name to set.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The phone number of the user.
     */
    public String getpNumber() {
        return pNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param pNumber The phone number to set.
     */
    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    /**
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The full name of the user (combination of first and last name).
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Updates the full name field by combining first and last names.
     */
    public void setFullName() {
        this.fullName = fName + " " + lName;
    }
}