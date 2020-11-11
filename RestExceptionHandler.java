package com.svsbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.svsbank.dto.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String ACCOUNTEXCEPTION = "Account-001";
	private static final String INSUFFICIENTFUNDCODE = "InsufficientFund-001";
	private static final String TRANSACTIONCODE = "Transaction-001";

	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(
			AccountNotFoundException accountNotFoundException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ACCOUNTEXCEPTION);
		errorResponse.setStatusMessage(accountNotFoundException.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InsufficientFundException.class)
	public ResponseEntity<ErrorResponse> handleCompanyNotFoundException(
			InsufficientFundException insufficientFundException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(INSUFFICIENTFUNDCODE);
		errorResponse.setStatusMessage(insufficientFundException.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = TransactionsNotavailableException.class)
	public ResponseEntity<ErrorResponse> handleCompanyNotFoundException(
			TransactionsNotavailableException transactionsNotAvailable) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(TRANSACTIONCODE);
		errorResponse.setStatusMessage(transactionsNotAvailable.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
