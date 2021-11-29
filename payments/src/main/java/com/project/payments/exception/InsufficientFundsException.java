package com.project.payments.exception;

public class InsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = 4840139757859192665L;

	public InsufficientFundsException() {
		super();
	}
	
	public InsufficientFundsException(String message) {
		super(message);
	}
}
