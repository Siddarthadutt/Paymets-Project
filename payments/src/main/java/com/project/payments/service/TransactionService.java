package com.project.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payments.model.Transaction;
import com.project.payments.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
}	
