package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gcu.services.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserBusinessService userBusinessService;

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
            .antMatchers("/products/**", "/applicants/**", "/editposting/**", "/jobDetails/**", "/newPosting/**", "/postingDetails/**", "/resumeDetails/**", "/userDetails/**", "/userList/**").authenticated() // Secure pages
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

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userBusinessService)
            .passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()); // For plain text passwords
    }

}
