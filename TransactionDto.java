package com.svsbank.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionDto {

	private Double amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss",timezone="Asia/Calcutta")
	private Date transactionDate;
	private String debitOrCreditStatus;


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDebitOrCreditStatus() {
		return debitOrCreditStatus;
	}

	public void setDebitOrCreditStatus(String debitOrCreditStatus) {
		this.debitOrCreditStatus = debitOrCreditStatus;
	}

}
