package com.svsbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svsbank.dto.TransactionDto;
import com.svsbank.dto.TransactionResponseDto;
import com.svsbank.entity.Account;
import com.svsbank.entity.Transaction;
import com.svsbank.exception.AccountNotFoundException;
import com.svsbank.exception.ErrorMessage;
import com.svsbank.exception.TransactionsNotavailableException;
import com.svsbank.repository.AccountRepository;
import com.svsbank.repository.TransactionRepository;
import com.svsbank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public TransactionResponseDto getLatestTransactions(Long accountNumber) throws AccountNotFoundException {
		List<TransactionDto> transationDtoList = new ArrayList<TransactionDto>();

		Account account = accountRepository.findByaccountNumberEquals(accountNumber);
		if (account == null) {
			throw new AccountNotFoundException(ErrorMessage.ACCOUNTNOTFOUNDEXCEPTION.getMessage());
		}

		List<Transaction> transactionsList = transactionRepository.getTransactionByAccountNumber(accountNumber);
		if (transactionsList.size() == 0) {
			throw new TransactionsNotavailableException(ErrorMessage.TRANSACTIONNOTAVAILABLE.getMessage());
		}

		TransactionResponseDto responseDto = new TransactionResponseDto();

		responseDto.setAccountHolderName(account.getAccountHolderName());
		responseDto.setAccountNumber(account.getAccountNumber());
		responseDto.setAccountType(account.getAccountType());
		responseDto.setBranchName(account.getBranchName());
		responseDto.setTotalBalance(account.getTotalBalance());

		transationDtoList = getTransactionDto(transactionsList, accountNumber);
		responseDto.getTransactionDtoList().addAll(transationDtoList);

		return responseDto;
	}

	public List<TransactionDto> getTransactionDto(List<Transaction> transactionList, Long accountNumber) {
		List<TransactionDto> transationDtoList = new ArrayList<TransactionDto>();
		transactionList.stream().forEach(transaction -> {
			TransactionDto transactionDto = new TransactionDto();
			transactionDto.setAmount(transaction.getAmount());
			transactionDto.setTransactionDate(transaction.getTransactionDate());
			if (accountNumber.equals(transaction.getFrom_AccountNumber())) {
				transactionDto.setDebitOrCreditStatus("Credited amount to:" + transaction.getTo_AccountNumber());
			} else {
				transactionDto.setDebitOrCreditStatus("Debited amount from:" + transaction.getFrom_AccountNumber());
			}
			transationDtoList.add(transactionDto);
		});
		return transationDtoList;
	}

}
