package com.gcu.business;

/*
 * Interface for handling user authentication
 */
public interface OrdersBusinessInterface {
	
	/*
	 * 
	 * @param username entered by user
	 * @param password entered by user
	 * @return true is successful, false if not
	 */
	public boolean authenticate(String username, String password);
}
