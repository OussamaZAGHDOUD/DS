package com.OZ.security;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
@EnableWebSecurity
@Data
@AllArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//http.cors().and().csrf().disable().authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
		
		http.authorizeRequests().antMatchers("/index").hasRole("ADMIN")
		.antMatchers("/**").hasRole("USER").and().formLogin();
		
	}
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return  NoOpPasswordEncoder.getInstance();
	}
}
