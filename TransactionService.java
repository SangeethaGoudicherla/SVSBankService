package com.svsbank.service;


import org.springframework.stereotype.Service;

import com.svsbank.dto.TransactionResponseDto;
import com.svsbank.exception.AccountNotFoundException;

@Service
public interface TransactionService {

	TransactionResponseDto getLatestTransactions(Long accountNumber) throws AccountNotFoundException;

}
