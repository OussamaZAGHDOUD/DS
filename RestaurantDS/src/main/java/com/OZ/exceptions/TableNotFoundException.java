package com.OZ.exceptions;

public class TableNotFoundException extends RuntimeException {

	public TableNotFoundException() {
		super("Table not found ! ");
	}
}
