package com.hackathon.ecoair.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hackathon.ecoair.model.ShipmentRegistry;

import java.util.Optional;

	public interface ShipmentRepository extends MongoRepository<ShipmentRegistry, Integer> {

	  Optional<ShipmentRegistry> findByShipmentId(int shipmentId);

	}
