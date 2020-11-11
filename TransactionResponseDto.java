package com.svsbank.dto;

import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {

	private String accountHolderName;
	private String accountType;
	private Long accountNumber;
	private String branchName;
	private Double totalBalance;

	private List<TransactionDto> transactionDtoList = new ArrayList<TransactionDto>();

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public List<TransactionDto> getTransactionDtoList() {
		return transactionDtoList;
	}

	public void setTransactionDtoList(List<TransactionDto> transactionDtoList) {
		this.transactionDtoList = transactionDtoList;
	}

}
