package com.project.payments.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This CustomerId does Not Exist");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public ResponseEntity<Object> handleBeneficiaryNotFoundException() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Beneficiary does not Exist");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<Object> handleInsufficientFundsException() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The customer does not have sufficient Funds");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SdnListException.class)
	public ResponseEntity<Object> handleSdnListException() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The reciever's name belongs in SdnList");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidTransactionException.class)
	public ResponseEntity<Object> handleInvalidTransactionException() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Bad transaction type");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

}
