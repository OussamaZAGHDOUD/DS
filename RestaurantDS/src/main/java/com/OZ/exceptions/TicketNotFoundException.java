package com.OZ.exceptions;

public class TicketNotFoundException extends RuntimeException {

	public TicketNotFoundException() {
		super("Ticket not found !");
	}
}
