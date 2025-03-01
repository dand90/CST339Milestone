package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gcu.services.UserBusinessService;
/**
 * Security class for the application
 * 
 * Sets up HTTp for authentication
 * 
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    /**
    * service used for user operations
    */
    @Autowired
    private UserBusinessService userBusinessService;
    
    /**
    * 
    * @param http The HttpSecurity object to configure.
    * @throws Exception If there is an error during configuration.
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
        .httpBasic()  
            .and()
            .authorizeRequests()
            .antMatchers("/service/**").authenticated()
            .and()   
            .authorizeRequests()
            .antMatchers("/", "/index", "/login", "/register", "/reLogin", "/css/**", "/js/**", "/images/**").permitAll() // Public pages
            .antMatchers("/products/**", "/service/products", "/applicants/**", "/editposting/**", "/jobDetails/**", "/newPosting/**", "/postingDetails/**", "/resumeDetails/**", "/userDetails/**", "/userList/**", "service/product/**").authenticated() // Secure pages
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .defaultSuccessUrl("/products", true)
            .and()
        .logout()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll()
            .logoutSuccessUrl("/");
    }
    /**
    *Configures user details and password encoding. 
    *
    * @param auth The AuthenticationManagerBuilder to configure.
    * @throws Exception If there is an error during configuration.
     */

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userBusinessService)
            .passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()); // For plain text passwords
    }

}
