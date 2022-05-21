package com.hackathon.ecoair.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ecoair.model.AgentRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
public class IataRegistryController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
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
		
		return new ResponseEntity<>(agentRegistryList, HttpStatus.OK);
	}
	@GetMapping(
			value = "/agent/{id}",
			produces = { HAL_JSON_VALUE }
			)
	public ResponseEntity<AgentRegistry> getAgentDetails(
			String id,
			HttpServletRequest request){
		return new ResponseEntity<>(new AgentRegistry(0,"9283048SG","Dash Air Cargo Freighter",38,15,2500.0,"GSG"), HttpStatus.OK);
	}
}