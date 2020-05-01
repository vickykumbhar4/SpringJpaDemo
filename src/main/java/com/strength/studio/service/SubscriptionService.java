package com.strength.studio.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.strength.studio.exception.ResourceNotFoundException;
import com.strength.studio.model.Subscription;
import com.strength.studio.repository.SubscriptionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository repository;
	
	public Subscription createSubscription(@Valid @NotBlank Subscription subscription){
		return repository.save(subscription);
	}
	
	public List<Subscription> getAll(){
		return repository.findAll();
	}
	
	public ResponseEntity<Subscription> findById(@NotBlank Long id) throws ResourceNotFoundException {
		Subscription sub = repository.findById(id).
				orElseThrow(
						() -> new ResourceNotFoundException("Subscription not found by id"+id));
		return ResponseEntity.ok().body(sub);
	}
}
