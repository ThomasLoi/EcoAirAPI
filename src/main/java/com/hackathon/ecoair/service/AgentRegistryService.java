package com.hackathon.ecoair.service;

import java.util.List;
import com.hackathon.ecoair.model.AgentRegistry;

public interface AgentRegistryService {
	  List<AgentRegistry> getCompanies();
	  AgentRegistry findByAgentId(String agentId);
}
