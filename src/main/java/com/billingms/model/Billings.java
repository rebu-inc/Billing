package com.billingms.model;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Billings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_id")
	private long user_id;

	@Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGIST_DATE", nullable = false)
    private Calendar registDate;

	@OneToMany(cascade = CascadeType.ALL)
    private List<Line_items> line_items;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payment;


	public Billings() {
	}

	public Billings(long id, long user_id, String status, Calendar registDate, List<Line_items> line_items,
			List<Payment> payment) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.status = status;
		this.registDate = registDate;
		this.line_items = line_items;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Calendar registDate) {
		this.registDate = registDate;
	}

	public List<Line_items> getLine_items() {
		return line_items;
	}

	public void setLine_items(List<Line_items> line_items) {
		this.line_items = line_items;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


}