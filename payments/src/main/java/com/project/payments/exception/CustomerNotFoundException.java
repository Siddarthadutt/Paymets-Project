package com.project.payments.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 272765504127800987L;

	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
}
