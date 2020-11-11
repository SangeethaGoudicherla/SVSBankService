package com.svsbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.svsbank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value = "select * from Transaction t where t.from_account_number =:accountNumber or t.to_account_number =:accountNumber order by t.transaction_id desc limit 10", nativeQuery = true)
	public List<Transaction> getTransactionByAccountNumber(@Param("accountNumber") Long accountNumber);

}
