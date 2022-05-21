package com.hackathon.ecoair.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hackathon.ecoair.model.AgentRegistry;

import java.util.Optional;

	public interface ParticipantRepository extends MongoRepository<AgentRegistry, String> {

	  Optional<AgentRegistry> findByAgentId(String id);

	}
