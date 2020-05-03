package com.aggregator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aggregator.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

	Optional<Provider> findByProviderName(String providerName);

}
