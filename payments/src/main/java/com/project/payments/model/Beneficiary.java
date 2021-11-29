package com.project.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receiver_table")
public class Beneficiary {
	@Id
	private long BIC;
	@Column
	private String bankName;
	
	public Beneficiary() {
		super();
	}
	
	public Beneficiary(long BIC, String bankName) {
		super();
		this.BIC = BIC;
		this.bankName = bankName;
	}
	
	public long getBIC() {
		return BIC;
	}
	
	public void setBIC(long BIC) {
		this.BIC = BIC;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return "Beneficiary [ BIC:" + BIC + " bankName: " + bankName + "]";
	}
}
