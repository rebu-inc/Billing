package com.billingms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Line_items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long item_id;
    private int quantity;

	public Line_items() {
	}

	public Line_items(long id, long item_id, int quantity) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.quantity = quantity;
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



}