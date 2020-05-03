package com.aggregator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aggregator.entity.Provider;
import com.aggregator.repository.ProviderRepository;



@Service
public class ProviderService {

	@Autowired
	public ProviderRepository repo;
	/*
	 * public Provider registerProvider(Provider provider) { return
	 * providerRepository.saveAndFlush(provider); }
	 */
	
	public Provider registerProvider(Provider provider) {
		return repo.saveAndFlush(provider);

	}
	

	public Provider checkProviderExists(String providerName) {
		Optional<Provider> providerObj = repo.findByProviderName(providerName);
		return providerObj.isPresent() ? providerObj.get() : null;

	}
}
