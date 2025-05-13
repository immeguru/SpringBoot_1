package com.yi_college.bookmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.yi_college.bookmanager.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		  return http
		.authenticationProvider(authenticationProvider())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.GET, "/api/books").hasAnyRole("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/api/books").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/books").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/books").hasRole("ADMIN")
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(form -> form.defaultSuccessUrl("/books", true)
				.failureUrl("login/error")
				.permitAll())
		.logout(logout -> logout.logoutSuccessUrl("/login")
				.permitAll())
//				.formLogin(withDefaults())
//				.logout(withDefaults())
		.exceptionHandling(ex -> ex.accessDeniedPage("/login?error"))
		.build();

	   
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		authenticationProvider.setUserDetailsService(userDetailsService);

		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	        authBuilder.authenticationProvider(authenticationProvider());
	        return authBuilder.build();
	}	        
	
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
