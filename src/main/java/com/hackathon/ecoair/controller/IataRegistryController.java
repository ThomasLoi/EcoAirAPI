package com.hackathon.ecoair.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ecoair.model.AgentRegistry;
import com.hackathon.ecoair.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
public class IataRegistryController {
	@Autowired
	private ParticipantRepository participantRepository;
	@PostMapping("/addAgent")
	  public ResponseEntity<Void> addAgent(@RequestBody AgentRegistry agentRegistry) {
		participantRepository.save(agentRegistry);
	    return new ResponseEntity<>(HttpStatus.OK);
	  }
	@GetMapping(
			value = "/agent",
			produces = { HAL_JSON_VALUE }
		)
		public ResponseEntity<List<AgentRegistry>> getAgentList(
			HttpServletRequest request){
		List<AgentRegistry> agentRegistryList = new ArrayList<>();
		agentRegistryList.add(new AgentRegistry(0,"9283048SG","Dash Air Cargo Freighter",38,15,2500.0,"GSG"));
		agentRegistryList.add(new AgentRegistry(1,"9283049SG","Omni Logistic",41,12,1850.0,"GS"));
		
		return new ResponseEntity<>(participantRepository.findAll(), HttpStatus.OK);
	}
	@GetMapping(
			value = "/agent/{agentId}",
			produces = { HAL_JSON_VALUE }
			)
	public Optional<AgentRegistry> getAgentDetails(
			@PathVariable int agentId){
		return participantRepository.findByAgentId(agentId);
	}
}