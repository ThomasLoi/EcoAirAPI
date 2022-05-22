package com.hackathon.ecoair.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ecoair.model.AgentRegistry;
import com.hackathon.ecoair.model.AirlineRegistry;
import com.hackathon.ecoair.repository.AirlineRepository;
import com.hackathon.ecoair.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
public class IataRegistryController {
	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private AirlineRepository airlineRepository;
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
	
	@PostMapping("/addAirline")
	public ResponseEntity<Void> addAirline(@RequestBody AirlineRegistry airlineRegistry) {
		airlineRepository.save(airlineRegistry);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping(
			value = "/airline",
			produces = { HAL_JSON_VALUE }
			)
	public ResponseEntity<List<AirlineRegistry>> getAirlineList(
			HttpServletRequest request){
		return new ResponseEntity<>(airlineRepository.findAll(), HttpStatus.OK);
	}
	@GetMapping(
			value = "/airline/{airlineId}",
			produces = { HAL_JSON_VALUE }
			)
	public Optional<AirlineRegistry> getAirlineDetails(
			@PathVariable int airlineId){
		return airlineRepository.findByAirlineId(airlineId);
	}
}