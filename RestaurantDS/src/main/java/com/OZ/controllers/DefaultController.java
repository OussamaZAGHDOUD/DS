package com.OZ.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.OZ.jwt.AuthenticationRequest;
import com.OZ.jwt.AuthenticationResponse;
import com.OZ.jwt.JwtUtil;
import com.OZ.services.MyUserDetailsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DefaultController {

	private AuthenticationManager authenticationManager;
	private MyUserDetailsService userDetailsService;
	private JwtUtil jwtToken;

	@RequestMapping({ "/", "/index" })
	public String helloUser() {
		return "<h1>hello USER ! </h1>";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtToken.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
