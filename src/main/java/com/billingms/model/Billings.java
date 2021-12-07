package com.billingms.model;


import java.util.List;

import javax.persistence.*;

@Entity
public class Billings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_id")
	private long user_id;

	@OneToMany(mappedBy = "billings")
    private List<Billing_Line_items> billing_line_items;
    
    @OneToMany(mappedBy = "billings")
    private List<Payment> payment;

	public Billings(long id, long user_id, List<Billing_Line_items> billing_line_items, List<Payment> payment) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.billing_line_items = billing_line_items;
		this.payment = payment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public List<Billing_Line_items> getBilling_line_items() {
		return billing_line_items;
	}

	public void setBilling_line_items(List<Billing_Line_items> billing_line_items) {
		this.billing_line_items = billing_line_items;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

    

}