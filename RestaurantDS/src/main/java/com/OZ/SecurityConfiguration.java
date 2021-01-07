package com.OZ;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Set your configuration in the auth object !
		auth.inMemoryAuthentication().withUser("oussama").password("oussama").roles("USER")
		.and()
		.withUser("mehdi").password("mehdi").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			// set your Authorization config !
		http.authorizeRequests()
		.regexMatchers("/ticket/.*","/client/.*","/table/.*","/met/.*").hasRole("ADMIN")
		.regexMatchers("/.*").permitAll()
		.and().formLogin();
		
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); 
	}
}
