package com.project.payments.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long transactionId;
	
	@Column
	private long customerId;
	
	@Column
	private long receiverId;
	
	@Column
	private String receiverName;
	
	@Column
	private double amount;
	
	@Column
	private String message;
	
	@Column
	private LocalDateTime dateTime;
	
	public Transaction() {
		super();
	}
	
	public Transaction(long transactionId, long customerId, long receiverId, String receiverName, double amount, String message, LocalDateTime dateTime) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.receiverId = receiverId;
		this.receiverName = receiverName;
		this.amount = amount;
		this.message = message;
		this.dateTime = dateTime;
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomer(long customerId) {
		this.customerId = customerId;
	}
	
	public long getReceiverId() {
		return receiverId;
	}
	
	public void setreceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	
	public String getReceiverName() {
		return receiverName;
	}
	
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount =amount;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "TransactionId: " + transactionId + " CustomerId: "+ customerId + "receiver:  " + receiverId +
			" receiverName: " + receiverName +" Amount: " + amount + " Message: "	+ message + "DateTime: " + dateTime;
	}
}
