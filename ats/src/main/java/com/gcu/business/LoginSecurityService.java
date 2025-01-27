package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class LoginSecurityService implements OrdersBusinessInterface{

	private String username = "123";
	private String password = "123";
	
	@Override
	public boolean authenticate(String username, String password) {
		if (username.equals(this.username) && password.equals(this.password)) {
			System.out.println("Hello from SecurityBusinessService");
			return true;
		}
		else return false;
	}
	
}
