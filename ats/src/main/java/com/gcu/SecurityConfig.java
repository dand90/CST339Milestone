package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.services.UserBusinessService;

@Configuration
public class SecurityConfig {

    private final UserBusinessService userBusinessService; // ✅ Inject Correct Service

    public SecurityConfig(UserBusinessService userBusinessService) {
        this.userBusinessService = userBusinessService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/login", "/register", "/css/**", "/images/**").permitAll() // Public pages
                .anyRequest().authenticated() // Secure all other pages
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/products/display", true)
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userBusinessService);
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // Use plain text passwords
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}