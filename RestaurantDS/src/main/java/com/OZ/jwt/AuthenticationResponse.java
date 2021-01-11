package com.OZ.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter 
public class AuthenticationResponse {

	private final String jwt;
	
}
