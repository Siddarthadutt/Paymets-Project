package com.project.payments.exception;

public class SdnListException extends RuntimeException{

	private static final long serialVersionUID = -8022397445793248357L;
	
	public SdnListException() {
		super();
	}
	
	public SdnListException(String message) {
		super(message);
	}
}
