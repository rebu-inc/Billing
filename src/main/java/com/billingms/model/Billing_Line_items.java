package com.billingms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Billing_Line_items {

    @Id
    @GeneratedValue
    private long id;
    
    private long item_id;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name="billings_id")
    private Billings billings;

	public Billing_Line_items(long id, long item_id, int quantity, Billings billings) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.billings = billings;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Billings getBillings() {
		return billings;
	}

	public void setBillings(Billings billings) {
		this.billings = billings;
	}
    
    
}