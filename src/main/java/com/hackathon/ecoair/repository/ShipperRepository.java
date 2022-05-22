package com.hackathon.ecoair.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hackathon.ecoair.model.ShipperRegistry;

import java.util.Optional;

	public interface ShipperRepository extends MongoRepository<ShipperRegistry, Integer> {

	  Optional<ShipperRegistry> findByShipperId(int shipperId);

	}
