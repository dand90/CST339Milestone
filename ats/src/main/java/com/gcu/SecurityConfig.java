	package com.gcu;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserBusinessService;


	@SuppressWarnings("deprecation")
	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {


		@Autowired
		private UserBusinessService service;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .authorizeRequests(requests -> requests
                            .antMatchers("/", "/login", "/reLogin", "/images/**", "/css/**", "/register").permitAll()
                            .anyRequest().authenticated())
                    .formLogin(login -> login
                            .loginPage("/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .permitAll()
                            .defaultSuccessUrl("/", true))
                    .logout(logout -> logout
                            .logoutUrl("/logout")
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .permitAll()
                            .logoutSuccessUrl("/"));
	    }
	
	/*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*//*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*/@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
		
		
		
	}
	
	
	
