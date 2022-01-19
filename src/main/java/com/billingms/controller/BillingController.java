package com.billingms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billingms.model.Billings;
import com.billingms.repository.BillingRepository;

@RestController
@RequestMapping("/api")
public class BillingController {

	@Autowired
	BillingRepository billingRepository;

	@GetMapping("/listbilling")
	public List<Billings> Get() {
		return billingRepository.findAll();
	}

	@DeleteMapping("/deletebilling/{id}")
	public ResponseEntity<HttpStatus> deleteBilling(@PathVariable("id") long id) {
		try {
			billingRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/billing/{id}")
	public ResponseEntity<Billings> getBilling(@PathVariable("id") long id) {
		try {
			Billings _billing = billingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid billing Id:" + id));
			return new ResponseEntity<>(_billing, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/billing")
	public ResponseEntity<Billings> postBilling(@RequestBody Billings billings) {
		//billingRepository.save(billings);
		try {
			Billings _billings = billingRepository.save(billings);
			return new ResponseEntity<>(_billings, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
