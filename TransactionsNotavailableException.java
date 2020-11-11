package com.svsbank.exception;

public class TransactionsNotavailableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionsNotavailableException(String message) {
		super(message);
	}
}
