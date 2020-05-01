package com.strength.studio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strength.studio.exception.ResourceNotFoundException;
import com.strength.studio.model.Subscription;
import com.strength.studio.service.SubscriptionService;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionService service;
	
	@GetMapping
	public List<Subscription> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getOne(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		return service.findById(id);
	}
	
	@PostMapping
	public Subscription create(@RequestBody Subscription body){
		return service.createSubscription(body);
	}
}
