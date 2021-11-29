package com.project.payments.exception;

public class InvalidTransactionException extends RuntimeException{
	
	private static final long serialVersionUID = -2972717666077195371L;

	public InvalidTransactionException() {
		super();
	}
	
	public InvalidTransactionException(String message) {
		super(message);
	}
}
