package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * LoginModel class used by LoginController
 */

public class LoginModel {
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;

	/*
	 * username
	 * @return username entered by user
	 */
	public String getUsername() {
		return username;
	}
	/*
	 * @param username to set username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * get password
	 * @return password entered by user
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
