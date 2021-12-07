package com.billingms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long id;
    
    private String amount;
    
    private String paymentType;
    
    @ManyToOne
    @JoinColumn(name="billings_id")
    private Billings billings;

	public Payment(long id, String amount, String paymentType, Billings billings) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentType = paymentType;
		this.billings = billings;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Billings getBillings() {
		return billings;
	}

	public void setBillings(Billings billings) {
		this.billings = billings;
	}
    
    
}
