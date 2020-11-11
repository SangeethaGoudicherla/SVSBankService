package com.svsbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.svsbank.dto.TransactionResponseDto;
import com.svsbank.exception.AccountNotFoundException;
import com.svsbank.service.TransactionService;

@RestController
@RequestMapping("/bank")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("/latestTransactions")
	public ResponseEntity<TransactionResponseDto> getLatestTransactions(@RequestParam Long accountNumber) throws AccountNotFoundException {
		return new ResponseEntity<TransactionResponseDto>(transactionService.getLatestTransactions(accountNumber),
				HttpStatus.OK);
	}
}
