package com.OZ.exceptions;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException() {
		super("Client not Found ! ");
	}
}
