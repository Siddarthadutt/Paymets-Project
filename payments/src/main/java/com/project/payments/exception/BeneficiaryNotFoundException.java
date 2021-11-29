package com.project.payments.exception;

public class BeneficiaryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5919384255678937062L;

	public BeneficiaryNotFoundException() {
		super();
	}
	
	public BeneficiaryNotFoundException(String message) {
		super(message);
	}
}
