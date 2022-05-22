package com.hackathon.ecoair.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hackathon.ecoair.model.AirlineRegistry;

import java.util.Optional;

	public interface AirlineRepository extends MongoRepository<AirlineRegistry, Integer> {

	  Optional<AirlineRegistry> findByAirlineId(int airlineId);

	}
