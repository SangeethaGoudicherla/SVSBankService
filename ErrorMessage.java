package com.svsbank.exception;

public enum ErrorMessage {
	
	ACCOUNTNOTFOUNDEXCEPTION("Account is not available in our application"), 
	INSUFFICIENTFUNDEXCEPTION("Insufficient fund available for the account"),
	TRANSACTIONNOTAVAILABLE("Still transactions are not tracked yet");
	
	
	private String message;

	public String getMessage() {
		return message;
	}

	private ErrorMessage(String message) {
		this.message = message;
	}
}