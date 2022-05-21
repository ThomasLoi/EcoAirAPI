package com.hackathon.ecoair.service.impl;

import java.util.List;

import com.hackathon.ecoair.model.AgentRegistry;
import com.hackathon.ecoair.repository.ParticipantRepository;
import com.hackathon.ecoair.service.AgentRegistryService;

public class AgentRegistryServiceImpl implements AgentRegistryService {
	private final ParticipantRepository participantRepository;

	public AgentRegistryServiceImpl(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}

	@Override
	public List<AgentRegistry> getCompanies() {
		return participantRepository.findAll();
	}

	@Override
	public AgentRegistry findByAgentId(String agentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
