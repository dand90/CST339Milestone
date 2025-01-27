package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.business.LoginSecurityService;
import com.gcu.business.OrdersBusinessInterface;

@Configuration
public class MilestoneConfig {

	@Bean(name="loginSecurity", initMethod="authenticate")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public OrdersBusinessInterface getSecurity() {
		return new LoginSecurityService();
	}
}
