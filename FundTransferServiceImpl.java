package com.svsbank.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.svsbank.dto.FundTransferRequestDto;
import com.svsbank.dto.ResponseDto;
import com.svsbank.entity.Account;
import com.svsbank.entity.Transaction;
import com.svsbank.exception.AccountNotFoundException;
import com.svsbank.exception.ErrorMessage;
import com.svsbank.repository.AccountRepository;
import com.svsbank.repository.TransactionRepository;
import com.svsbank.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	Environment environment;

	private static final String SUCCESS = "success";

	@Override
	@Transactional
	public ResponseDto fundTransfer(List<FundTransferRequestDto> fundTransferRequestDtos)
			throws AccountNotFoundException {
		ResponseDto responseDto = new ResponseDto();

		for (FundTransferRequestDto fundTransferRequestDto : fundTransferRequestDtos) {
			Account fromAccount = accountRepository
					.findByaccountNumberEquals(fundTransferRequestDto.getFrom_AccountNumber());
			Account toAccount = accountRepository
					.findByaccountNumberEquals(fundTransferRequestDto.getTo_AccountNumber());

			if (fromAccount == null || toAccount == null) {
				responseDto.setStatusMessage(ErrorMessage.ACCOUNTNOTFOUNDEXCEPTION.getMessage());
				return responseDto;
			}

			Double amount = fundTransferRequestDto.getAmount();
			if (fromAccount.getTotalBalance() < amount) {
				responseDto.setStatusMessage(ErrorMessage.INSUFFICIENTFUNDEXCEPTION.getMessage());
				return responseDto;
			}

			fromAccount.setTotalBalance(fromAccount.getTotalBalance() - amount);
			toAccount.setTotalBalance(toAccount.getTotalBalance() + amount);
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);

			// Create Transaction
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setFrom_AccountNumber(fromAccount.getAccountNumber());
			transaction.setTo_AccountNumber(toAccount.getAccountNumber());

			transaction.setRemarks(fundTransferRequestDto.getRemarks());
			transaction.setTransactionDate(Calendar.getInstance().getTime());

			Random num = new Random();
			Long referenceNumber = num.nextLong() + 1;
			transaction.setReferenceNumber(referenceNumber);
			transactionRepository.save(transaction);
		}
		responseDto.setStatusMessage(SUCCESS);
		return responseDto;
	}

}
