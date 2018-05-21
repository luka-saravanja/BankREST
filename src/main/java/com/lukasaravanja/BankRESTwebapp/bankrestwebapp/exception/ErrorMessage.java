package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.exception;

public class ErrorMessage {

	private String message;
	
	private String details;

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public ErrorMessage(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	
	
	
	
	
}
