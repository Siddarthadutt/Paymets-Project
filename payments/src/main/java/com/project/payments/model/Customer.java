package com.project.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {
	
	@Id
	private long customerId;
	@Column
	private String customerName;
	@Column
	private double balance;
	@Column
	private long bankId;
	@Column
	private boolean overDraft;
	@Column
	private boolean isBank;
	
	public Customer() {
		super();
	}
	
	public Customer(long customerId, String customerName, double balance, long bankId,boolean overDraft, boolean isBank) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.balance = balance;
		this.bankId = bankId;
		this.overDraft = overDraft;
		this.isBank = isBank;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public long getBankId() {
		return bankId;
	}
	
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	
	public boolean getOverDraft() {
		return overDraft;
	}
	
	public void setOverDraft(boolean overDraft) {
		this.overDraft = overDraft;
	}
	
	public boolean getIsBank() {
		return isBank;
	}
	
	public void setIsBank(boolean isBank) {
		this.isBank = isBank;
	}
	
	@Override
	public String toString() {
		return "Customer [ CustomerId: " + customerId + " customerName: " + customerName + " balance: " + balance + 
			" bankId: "+ bankId + " overDraft: " + (overDraft == true ? "Yes" : "No") + " AccountType: " +(isBank == true ? "Bank" : "Customer") +" ]";
	}
	
	
	
}
