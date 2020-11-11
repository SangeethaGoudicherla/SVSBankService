package com.svsbank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	private Long referenceNumber;
	private Date transactionDate;
	private String remarks;
	private Double amount;
	private Long from_AccountNumber;
	private Long to_AccountNumber;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getFrom_AccountNumber() {
		return from_AccountNumber;
	}

	public void setFrom_AccountNumber(Long from_AccountNumber) {
		this.from_AccountNumber = from_AccountNumber;
	}

	public Long getTo_AccountNumber() {
		return to_AccountNumber;
	}

	public void setTo_AccountNumber(Long to_AccountNumber) {
		this.to_AccountNumber = to_AccountNumber;
	}

}
