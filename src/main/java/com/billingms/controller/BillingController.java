package com.billingms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/billings")
	public List<Billings> Get() {
		return billingRepository.findAll();
	}

	@DeleteMapping("/billings/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			billingRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/billings")
	public ResponseEntity<Billings> postStudent(@RequestBody Billings biliings) {
		billingRepository.save(biliings);
		try {
			Billings _biliings = billingRepository
					.save(biliings);
			return new ResponseEntity<>(_biliings, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
