package com.billingms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String amount;

    private String paymentType;

    /*@ManyToOne
    @JoinColumn(name="billings_id")
    private Billings billings; */



	public Payment(long id, String amount, String paymentType) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentType = paymentType;
	}

	public Payment() {
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


}
