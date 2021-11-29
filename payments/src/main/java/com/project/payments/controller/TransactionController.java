package com.project.payments.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.payments.exception.BeneficiaryNotFoundException;
import com.project.payments.exception.InsufficientFundsException;
import com.project.payments.exception.InvalidTransactionException;
import com.project.payments.exception.SdnListException;
import com.project.payments.model.Customer;
import com.project.payments.model.Transaction;
import com.project.payments.service.BeneficiaryService;
import com.project.payments.service.CustomerService;
import com.project.payments.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/transaction")
	public Customer addTransaction(@RequestBody Transaction transaction) {
		Customer customer = customerService.getCustomerById(transaction.getCustomerId());
		double amount = transaction.getAmount();
		double bankFees = amount*(0.0025);
		double balance = customer.getBalance() - amount;
		if(!customer.getIsBank()) {
			balance -= bankFees;
		}
		if(balance < 0 && !customer.getOverDraft()) {
			throw new InsufficientFundsException(String.format("%s's account does not have enough balance", customer.getCustomerName()));
		} 
		if(customer.getIsBank()) {
			bankTransfer(transaction.getReceiverId(), amount);
		} else if(!beneficiaryService.hasBeneficiaryId(transaction.getReceiverId())) {
				throw new BeneficiaryNotFoundException(String.format("%s is not a known receiver", transaction.getReceiverName()));
		} else if(sdnListContains(transaction.getReceiverName().toLowerCase())) {
				System.out.println("belongs in sdb list");
				throw new SdnListException(String.format( "Name %s matches with that of a criminal" , transaction.getReceiverName()));
		} else {
			bankTransfer(customer.getBankId(),bankFees);
		}
		System.out.println("Not in sdn list");
		transactionService.addTransaction(transaction);
		customerService.updateBalanceById(customer.getCustomerId(), balance);
		customer.setBalance(balance);
		return customer;
	}
	
	private void bankTransfer(long receiverId, double amount) {
		Customer receiver = customerService.getCustomerById(receiverId);
		if(!receiver.getIsBank()) {
			throw new InvalidTransactionException("Bank-customer transaction is not supported");
		}
		double balance = receiver.getBalance() + amount;
		System.out.println(amount);
		customerService.updateBalanceById(receiverId, balance);
		receiver.setBalance(balance);
	}

	private boolean sdnListContains(String name) {
		String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\payments\\src\\main\\java\\com\\project\\payments\\controller\\sdnlist.txt";
		
	    Scanner sc;
		try {
			sc = new Scanner(new File(filePath));
			while (sc.hasNextLine()) {
				if(sc.nextLine().toLowerCase().contains(name)) {
					return true;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return false;
	}
	
}
